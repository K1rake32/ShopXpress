package com.example.shopxpress.storage

import android.content.Context
import androidx.annotation.RequiresApi
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.shopxpress.storage.data.SettingsData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("data_store")

class DataStoreManager(val context: Context) {

    companion object {
        private val SEARCH_HISTORY_KEY = stringSetPreferencesKey("search_history")
    }

    suspend fun addSearchQuery(query: String) {
        context.dataStore.edit { preferences ->
            val currentHistory = preferences[SEARCH_HISTORY_KEY] ?: emptySet()
            preferences[SEARCH_HISTORY_KEY] = (currentHistory + query)
                .toList()
                .takeLast(10)
                .toSet()
        }
    }

    suspend fun removeSearchQuery(query: String) {
        context.dataStore.edit { preferences ->
            val currentHistory = preferences[SEARCH_HISTORY_KEY] ?: emptySet()
            preferences[SEARCH_HISTORY_KEY] = currentHistory - query
        }
    }
    fun getSearchHistory(): Flow<List<String>> = context.dataStore.data.map { preferences ->
        preferences[SEARCH_HISTORY_KEY]?.toList()?.reversed() ?: emptyList()
    }

}
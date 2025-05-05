package com.example.shopxpress.presentation.ui.screens.auth.Signup.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.absoluteValue

class MaskVisualTransformation(private val mask: String) : VisualTransformation {

    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }
    private val maxSymbol = mask.count { it == '#' }

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        var charCount = 0

        text.forEach { char ->

            if (charCount >= maxSymbol) {
                return@forEach
            }

            while (maskIndex < mask.length && specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }

            if (maskIndex < mask.length) {
                out += char
                maskIndex++
            }
            charCount++
        }

        return TransformedText(AnnotatedString(out), offsetTranslator())
    }
    private fun offsetTranslator() = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 0) return 0
            var hashtagsSeen = 0
            var index = 0
            while (index < mask.length && hashtagsSeen < offset) {
                if (mask[index] == '#') {
                    hashtagsSeen++
                }
                index++
            }
            return index.coerceAtMost(mask.length)
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 0) return 0
            var hashtagsSeen = 0
            var index = 0
            while (index < offset && index < mask.length) {
                if (mask[index] == '#') {
                    hashtagsSeen++
                }
                index++
            }
            return hashtagsSeen
        }
    }
}
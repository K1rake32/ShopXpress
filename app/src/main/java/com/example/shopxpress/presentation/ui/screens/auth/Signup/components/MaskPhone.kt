package com.example.shopxpress.presentation.ui.screens.auth.Signup.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.absoluteValue

class MaskVisualTransformation(private val mask: String): VisualTransformation {

    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }
    private val maxSymbol = 10

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        var charCount = 0
        text.forEach {  char ->

            if (charCount >= maxSymbol) {
                return@forEach
            }

            while (specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }

            out += char
            maskIndex++
            charCount++
        }

        return TransformedText(AnnotatedString(out),offsetTranslator())

    }

    private fun offsetTranslator() = object: OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0
            var numberOfHashtags = 0
            val masked = mask.takeWhile {
                if (it == '#') numberOfHashtags++
                numberOfHashtags < offsetValue
            }
            return masked.length + 1
        }

        override fun transformedToOriginal(offset: Int): Int {
            return mask.take(offset.absoluteValue).count { it == '#' }
        }
    }

}
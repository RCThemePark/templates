package net.rcthemepark.showscripting.groovy.framework

import java.util.*

enum class ShowActionType {
    TEXT, CMD, CLOSURE, SEQUENCE;

    companion object {
        fun fromString(string: String): ShowActionType {
            return when (string.lowercase(Locale.getDefault())) {
                "text" -> TEXT
                "cmd" -> CMD
                "sequence" -> SEQUENCE
                else -> throw IllegalArgumentException("$string is not a valid")
            }
        }
    }
}
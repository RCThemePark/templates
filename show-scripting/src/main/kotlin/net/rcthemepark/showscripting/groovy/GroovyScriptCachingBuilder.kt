package net.rcthemepark.showscripting.groovy

import groovy.lang.GroovyShell
import groovy.lang.Script

class GroovyScriptCachingBuilder(private val groovyShell: GroovyShell) {
    private val scripts: MutableMap<String?, Script?> = HashMap()

    fun getScript(expression: String): Script {
        val script: Script = if (scripts.containsKey(expression)) {
            scripts[expression]!!
        } else {
           groovyShell.parse(expression)
        }
        scripts[expression] = script
        return script
    }
}
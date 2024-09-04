package net.rcthemepark.showscripting.groovy

import groovy.lang.Script
import net.rcthemepark.showscripting.groovy.GroovyCompiler.shell

class GroovyEvaluator(contextVariables: Map<String, Any> = HashMap()) {

    fun evaluateExpression(expression: String): Any? {
        val script = shell.parse(expression)
        synchronized(script) {
            return script.run()
        }
    }

    fun getScript(expression: String): Script {
        return shell.parse(expression)
    }
}
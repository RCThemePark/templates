package net.rcthemepark.showscripting.groovy

import addon.rcthemepark.RCTPAddonCore
import groovy.lang.GroovyShell
import net.rcthemepark.showscripting.groovy.dsl.TimecodeDsl
import org.codehaus.groovy.control.CompilerConfiguration


object GroovyCompiler {

    val evaluator: GroovyEvaluator = GroovyEvaluator()
    private var config: CompilerConfiguration = CompilerConfiguration().apply {
        this.scriptBaseClass = TimecodeDsl::class.java.name
    }
    val shell: GroovyShell = GroovyShell(RCTPAddonCore::class.java.classLoader, config)

}
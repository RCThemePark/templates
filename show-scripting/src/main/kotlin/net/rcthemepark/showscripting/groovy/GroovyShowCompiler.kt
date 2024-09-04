package net.rcthemepark.showscripting.groovy

import net.rcthemepark.showscripting.IShow
import net.rcthemepark.showscripting.groovy.dsl.TimecodeDsl
import net.rcthemepark.showscripting.groovy.framework.ShowActionType
import java.io.File

object GroovyShowCompiler {
    fun init(){
        GroovyCompiler.evaluator.evaluateExpression("println 'test'")
    }

    fun eval(show: IShow, file: File): Boolean {
        if(!file.exists()){
            return false
        }

        val finalText = file.readText().split("//START")[1]

        val dsl = GroovyCompiler.evaluator.getScript(finalText)
        val d = dsl as TimecodeDsl
        for (entry in d.evaluate(arrayOf()).entries) {
            val time = entry.key.toLong()
            val actions = entry.value

            for (action in actions) {
                if(action.type == ShowActionType.SEQUENCE){
                    val name = action.stringProp("name")
                    eval(show, File("storage/show/$name.groovy"))
                } else {
                    show.addAction(time, action)
                }
            }
        }
        return true
    }
}
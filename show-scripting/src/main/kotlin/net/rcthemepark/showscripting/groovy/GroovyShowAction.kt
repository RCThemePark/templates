package net.rcthemepark.showscripting.groovy

import groovy.lang.GString
import net.rcthemepark.showscripting.groovy.framework.ShowAction
import net.rcthemepark.showscripting.groovy.framework.ShowActionType

class GroovyShowAction(action: ShowActionType, propMap: Map<String, *>) :
    ShowAction(action, propMap) {

    override fun doubleProp(key: String): Double {
        val prop = propertyMap[key]
        return if (prop is Int) {
            prop.toDouble()
        } else if (prop is GString) {
            prop.toString().toDouble()
        } else {
            prop as Double
        }
    }

    override fun boolProp(key: String): Boolean {
        val prop = propertyMap[key]
        return if (prop is GString) {
            prop.toString().toBoolean()
        } else {
            prop as Boolean
        }
    }

    override fun stringProp(key: String): String {
        val prop = propertyMap[key]
        if (prop is GString) {
            return prop.toString()
        }

        return prop as String
    }

    override fun intProp(key: String): Int {
        val prop = propertyMap[key]
        return if (prop is GString) {
            prop.toString().toInt()
        } else {
            prop as Int
        }
    }

}
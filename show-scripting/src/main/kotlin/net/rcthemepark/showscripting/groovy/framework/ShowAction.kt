package net.rcthemepark.showscripting.groovy.framework

abstract class ShowAction(val type: ShowActionType, val propertyMap: Map<String, *>) {

    abstract fun doubleProp(key: String): Double

    abstract fun boolProp(key: String): Boolean

    abstract fun stringProp(key: String): String

    abstract fun intProp(key: String): Int


}
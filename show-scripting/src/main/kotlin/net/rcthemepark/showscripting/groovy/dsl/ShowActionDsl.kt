package net.rcthemepark.showscripting.groovy.dsl

import groovy.lang.Closure
import groovy.lang.DelegatesTo
import net.rcthemepark.showscripting.groovy.GroovyShowAction
import net.rcthemepark.showscripting.groovy.framework.ShowAction
import net.rcthemepark.showscripting.groovy.framework.ShowActionType

class ShowActionDsl(val time: Int) {

    var actions: MutableList<ShowAction> = mutableListOf()

    fun text(@DelegatesTo(value = String::class) closure: Closure<*>) {
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        actions.add(
            GroovyShowAction(
                ShowActionType.TEXT, hashMapOf(
                    Pair(
                        "text", closure.call()
                    )
                )
            )
        )
    }
}
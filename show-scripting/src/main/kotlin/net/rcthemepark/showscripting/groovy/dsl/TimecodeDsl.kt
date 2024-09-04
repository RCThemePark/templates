package net.rcthemepark.showscripting.groovy.dsl

import groovy.lang.Closure
import groovy.lang.DelegatesTo
import groovy.lang.Script
import groovy.transform.BaseScript
import net.rcthemepark.showscripting.groovy.framework.ShowAction

@BaseScript
abstract class TimecodeDsl : Script() {
    var actions: MutableMap<Int, MutableList<ShowAction>> = hashMapOf()
        protected set
    private var showClosure: Closure<*>? = null

    fun evaluate(args: Array<Any?>?):  MutableMap<Int, MutableList<ShowAction>> {
        actions = hashMapOf()
        run()

        if (showClosure != null) {
            showClosure!!.call(args)
        }
        return actions
    }

    fun at(time: Int, @DelegatesTo(value = ShowActionDsl::class) closure: Closure<Void>) {
        val actionDsl = ShowActionDsl(time)
        closure.delegate = actionDsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.call()
        for (action in actionDsl.actions) {
            actions.computeIfAbsent(time) { mutableListOf() }.add(action)
        }
    }
}
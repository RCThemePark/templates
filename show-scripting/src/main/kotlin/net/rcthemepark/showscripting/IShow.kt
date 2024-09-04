package net.rcthemepark.showscripting

import net.rcthemepark.showscripting.groovy.framework.ShowAction

interface IShow {

    val actions: MutableMap<Long, MutableList<ShowAction>>

    fun onInit()
    fun onTick(time: Long){
        for (actionEntry in actions) {
            if(actionEntry.key == time){
                for (showAction in actionEntry.value) {
                    executeAction(showAction)
                }
            }
        }
    }

    fun executeAction(action: ShowAction)
    fun onPlay(time: Long)
    fun addAction(time: Long, action: ShowAction)

}
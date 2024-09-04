#!/usr/bin/env groovy
package show.sequence

import net.rcthemepark.showscripting.groovy.dsl.TimecodeDsl
import groovy.transform.BaseScript
@BaseScript TimecodeDsl baseDsl

//SEQUENCE "test.groovy"
//START

def sequencerPrefix = "<blue><bold>Sequencer<reset><gray>"

at(20){
    text {"$sequencerPrefix i am a storyteller!"}
}

at(40){
    text {"$sequencerPrefix no im not anymore"}
}
#!/usr/bin/env groovy
package show

import net.rcthemepark.showscripting.groovy.dsl.TimecodeDsl
import groovy.transform.BaseScript
@BaseScript TimecodeDsl baseDsl

//SHOW "show.groovy"
//START
at(0){
    sequence {
        "sequence/test"
    }
}

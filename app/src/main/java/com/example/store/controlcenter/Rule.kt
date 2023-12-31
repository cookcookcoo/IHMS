package com.example.store.controlcenter

import com.example.store.controlcenter.Operation
import java.io.Serializable

class Rule(val ruleID: Int, var ruleName: String, val operationList: ArrayList<Operation>) :
    Serializable {

    fun execute() {
        for (operation in operationList) {
            operation.run()
        }
    }

}
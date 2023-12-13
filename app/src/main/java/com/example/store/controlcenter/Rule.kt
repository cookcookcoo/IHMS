package com.example.store.controlcenter

import com.example.store.controlcenter.Operation

class Rule(val ruleID: Int, var ruleName: String, val operationList: ArrayList<Operation>) {

    fun addOperation(operation: Operation) {
        operationList.add(operation)
    }

}
package com.example.store.device

import com.example.store.controlcenter.Operation

open class Device(
    val deviceID: Int,
    var name: String = "",
    var powerConsumption: Int = 0,
    var status: Boolean = false,
) {

    open fun changeOperation(operation: Operation) {
        when (operation.operation) {
            "turnOn" -> status = true
            "turnOff" -> status = false
        }
    }

    fun generateEnergyUsing() {
    }
}







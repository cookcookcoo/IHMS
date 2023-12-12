package com.example.store.device

import com.example.store.controlcenter.Operation
import kotlin.math.max

class AirConditioner(deviceID:Int, name:String, var temperature: Int = 26): Device(deviceID, name) {

    init {
        minPower = 100
        maxPower = 120
    }

    fun changeTemp(temp: Int) {
        this.temperature = temp
    }


    override fun changeOperation(operation: Operation) {
        when (operation.operation) {
            "turnOn" -> status = true
            "turnOff" -> status = false
            "changeTemp" -> changeTemp(operation.para)
        }
    }
}


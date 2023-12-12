package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class AirConditioner(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_ac,
    type:String = "AirConditioner",
    var temperature: Int = 26
) : Device(deviceID, name, imageID, type) {

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


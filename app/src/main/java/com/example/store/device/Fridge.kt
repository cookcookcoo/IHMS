package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Fridge(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_bedroomlight,
    type: String = "Fridge",
    var temperature: Int = 0
) : Device(deviceID, name, imageID, type) {


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
package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class AirConditioner(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_ac,
    type: String = "AirConditioner",
) : Device(deviceID, name, imageID, type) {

    var temperature: Int = 26
    init {
        minPower = 100
        maxPower = 120
    }


    override fun changeOperation(operation: Operation) {
        super.changeOperation(operation)
        when (operation.operation) {
            "ChangeTemp" -> temperature = operation.para
        }
    }
}


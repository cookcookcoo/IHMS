package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Fridge(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_fridge,
    type: String = "Fridge"
) : Device(deviceID, name, imageID, type) {

    var upperTemperature: Int = 0
    var lowerTemperature: Int = 0

    init {
        availableOperations.apply {
            add(AvailableOperation("ChangeUpperTemp", listOf(-5, -4, -3, -2, -1, 0)))
            add(AvailableOperation("ChangeLowerTemp", listOf(0, 1, 2, 3, 4, 5)))
        }
    }


    override fun changeOperation(operation: String, para: Int) {
        when (operation) {
            "TurnOn" -> {
                status = true
                minPower = 70
                maxPower = 90
            }

            "TurnOff" -> {
                status = false
                minPower = 0
                maxPower = 0
            }

            "ChangeUpperTemp" -> upperTemperature = para
            "ChangeLowerTemp" -> lowerTemperature = para
        }
    }
}
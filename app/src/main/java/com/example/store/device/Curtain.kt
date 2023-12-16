package com.example.store.device

import com.example.store.R

class Curtain(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_curtain,
    type: String = "Curtain",
) : Device(deviceID, name, imageID, type) {

    var openingRate: Int = 0

    init {
        availableOperations.apply {
            add(AvailableOperation("ChangeOpeningRate", listOf(0, 1, 2, 3, 4, 5)))
        }
    }

    override fun changeOperation(operation: String, para: Int) {
        when (operation) {
            "TurnOn" -> status = true
            "TurnOff" -> status = false
            "ChangeOpeningRate" -> openingRate = para
        }
    }

}
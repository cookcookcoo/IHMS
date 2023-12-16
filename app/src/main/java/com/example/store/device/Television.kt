package com.example.store.device

import com.example.store.R

class Television(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_tv,
    type: String = "Television",
) : Device(deviceID, name, imageID, type) {

    var channel: Int = 1
    var volume: Int = 0

    init {
        availableOperations.apply {
            add(AvailableOperation("ChangeChannel", listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
            add(AvailableOperation("ChangeVolume", listOf(0, 1, 2, 3, 4, 5)))
        }
    }


    override fun changeOperation(operation: String, para: Int) {
        when (operation) {
            "TurnOn" -> {
                status = true
                minPower = 60
                maxPower = 70
            }

            "TurnOff" -> {
                status = false
                minPower = 0
                maxPower = 0
            }

            "ChangeChannel" -> channel = para
            "ChangeVolume" -> volume = para
        }
    }
}
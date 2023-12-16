package com.example.store.device

import com.example.store.R

class Fan(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_fan,
    type: String = "Fan",
) : Device(deviceID, name, imageID, type) {

    var rotate: Int = 0
    var windSpeed: Int = 0

    init {
        availableOperations.apply {
            add(AvailableOperation("Rotate", listOf(0)))
            add(AvailableOperation("Stop", listOf(0)))
            add(AvailableOperation("ChangeWindSpeed", listOf(0, 1, 2, 3, 4, 5)))
        }
    }

    override fun changeOperation(operation: String, para: Int) {
        when (operation) {
            "TurnOn" -> {
                status = true
                minPower = 40
                maxPower = 60
            }

            "TurnOff" -> {
                status = false
                minPower = 0
                maxPower = 0
            }

            "Rotate" -> rotate = 1
            "Stop" -> rotate = 0
            "ChangeWindSpeed" -> windSpeed = para
        }
    }
}
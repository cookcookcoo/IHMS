package com.example.store.device

import com.example.store.R

class Light(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_light,
    type: String = "Light"
) :
    Device(deviceID, name, imageID, type) {

    var luminance = 0

    init {
        availableOperations.add(
            AvailableOperation("ChangeLuminance", listOf(1, 2, 3, 4, 5))
        )
    }

    override fun changeOperation(operation: String, para: Int) {
        when (operation) {
            "TurnOn" -> {
                status = true
                minPower = 5
                maxPower = 8
            }

            "TurnOff" -> {
                status = false
                minPower = 0
                maxPower = 0
            }

            "ChangeLuminance" -> luminance = para
        }
    }
}
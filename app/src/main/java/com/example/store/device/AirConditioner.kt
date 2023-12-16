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
    var windSpeed: Int = 0
    var windDirection: Int = 0

    init {

    }


    override fun changeOperation(operation: String, para: Int) {
        when (operation) {
            "TurnOn" -> {
                status = true
                minPower = 100
                maxPower = 120
            }

            "TurnOff" -> {
                status = false
                minPower = 0
                maxPower = 0
            }

            "ChangeTemp" -> temperature = para
            "ChangeWindSpeed" -> windSpeed = para
            "ChangeWindDirection" -> windDirection = para
        }
    }
}


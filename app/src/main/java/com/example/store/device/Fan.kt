package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Fan(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_camera,
    type: String = "Fan",
) : Device(deviceID, name, imageID, type) {

    var rotate: Int = 0
    var windSpeed: Int = 0

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
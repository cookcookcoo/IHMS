package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Television(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_tv,
    type: String = "Television",
) : Device(deviceID, name, imageID, type) {

    var channel: Int = 1
    var volume: Int = 0


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
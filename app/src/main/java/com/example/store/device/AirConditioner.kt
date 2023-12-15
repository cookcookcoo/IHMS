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
    var windSpeed:Int = 0
    var windDirection:Int = 0

    init {
        minPower = 100
        maxPower = 120
    }


    override fun changeOperation(operation:String, para:Int) {
        super.changeOperation(operation,para)
        when (operation) {
            "ChangeTemp" -> temperature = para
            "ChangeWindSpeed" -> windSpeed = para
            "ChangeWindDirection" -> windDirection = para
        }
    }
}


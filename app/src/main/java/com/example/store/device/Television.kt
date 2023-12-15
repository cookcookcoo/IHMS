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
    var volume:Int = 0


    override fun changeOperation(operation: String, para:Int) {
        super.changeOperation(operation,para)
        when (operation) {
            "ChangeChannel" -> channel = para
            "ChangeVolume" -> volume = para
        }
    }
}
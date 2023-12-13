package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Light(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_light,
    type: String = "Light"
) :
    Device(deviceID, name, imageID, type) {

        var luminance = 0

    override fun changeOperation(operation: Operation) {
        super.changeOperation(operation)
        when (operation.operation) {
            "ChangeLuminance" -> luminance = operation.para
        }
    }
}
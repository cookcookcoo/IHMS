package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Fridge(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_bedroomlight,
    type: String = "Fridge"
) : Device(deviceID, name, imageID, type) {
    var temperature: Int = 0





    override fun changeOperation(operation: Operation) {
        super.changeOperation(operation)
        when (operation.operation) {
            "ChangeTemp" -> temperature = operation.para
        }
    }
}
package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Curtain(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_curtain,
    type:String = "Curtain",
) : Device(deviceID, name, imageID, type) {

    var openingRate:Int = 0

    override fun changeOperation(operation: Operation) {
        super.changeOperation(operation)
        when (operation.operation) {
            "ChangeOpeningRate" -> openingRate = operation.para
        }
    }

}
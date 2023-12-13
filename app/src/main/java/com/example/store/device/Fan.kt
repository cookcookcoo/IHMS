package com.example.store.device

import com.example.store.R
import com.example.store.controlcenter.Operation

class Fan(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_camera,
    type:String = "Fan",
) : Device(deviceID, name, imageID, type) {

    var rotate:Int = 0
    var windSpeed:Int = 0

    override fun changeOperation(operation: Operation) {
        super.changeOperation(operation)
        when (operation.operation) {
            "Rotate" -> rotate = 1
            "Stop" -> rotate = 0
            "ChangeWindSpeed" -> windSpeed = operation.para
        }
    }
}
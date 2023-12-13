package com.example.store.device

import com.example.store.R

class Fan(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_camera,
    type:String = "Fan",
) : Device(deviceID, name, imageID, type) {
}
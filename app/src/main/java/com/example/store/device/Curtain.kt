package com.example.store.device

import com.example.store.R

class Curtain(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_curtain,
    type:String = "Curtain",
) : Device(deviceID, name, imageID, type) {
}
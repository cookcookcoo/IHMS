package com.example.store.device

import com.example.store.R
import com.example.store.device.Device

class Light(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_light,
    type: String = "Light"
) :
    Device(deviceID, name, imageID, type) {
}
package com.example.store.controlcenter

import com.example.store.device.Device
import java.io.Serializable

class Operation(val device: Device, val operation: String, val para: Int):Serializable {

    fun run() {
        device.changeOperation(this)
    }
}
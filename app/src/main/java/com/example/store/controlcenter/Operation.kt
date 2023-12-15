package com.example.store.controlcenter

import android.util.Log
import com.example.store.device.Device
import java.io.Serializable

class Operation(val device: Device, val operation: String, val para: Int):Serializable {

    fun run() {
        device.changeOperation(operation, para)
//        Log.d("Device", device.status.toString())
    }
}
package com.example.store.device

import android.util.Log
import com.example.store.R
import com.example.store.controlcenter.Operation
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class Light(
    deviceID: Int,
    name: String,
    imageID: Int = R.drawable.device_light,
    type: String = "Light"
) :
    Device(deviceID, name, imageID, type) {

    init {
        val random = java.util.Random()
        Timer().schedule(object: TimerTask(){
            override fun run() {
                Log.d("$name", "$name, $status, $luminance")
            }
        }, Date(), 300)
    }

    var luminance = 0

    init {
        availableOperations.add(
            AvailableOperation("ChangeLuminance", listOf("1","2","3","4","5"))
        )
    }

    override fun changeOperation(operation: String, para:Int) {
        super.changeOperation(operation,para)
        when (operation) {
            "ChangeLuminance" -> luminance = para
        }
    }
}
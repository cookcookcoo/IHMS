package com.example.store.device

import android.util.Log
import com.example.store.R
import com.example.store.controlcenter.Operation
import java.util.Date
import java.util.Timer
import java.util.TimerTask

open class Device(
    val deviceID: Int,
    var name: String = "",
    var imageID:Int = R.drawable.device_bedroomlight,
    var type:String = "Device",
    var status: Boolean = false
) {

    var currentPower = 0
    var minPower = 0
    var maxPower = 0

    init {
        val random = java.util.Random()
        Timer().schedule(object: TimerTask(){
            override fun run() {
                currentPower = random.nextInt(maxPower-minPower+1) + minPower
                Log.d("Device", "$deviceID $name Power Changed, now is $currentPower .")
            }
        }, Date(), 5000)
    }
    open fun changeOperation(operation: Operation) {
        when (operation.operation) {
            "turnOn" -> status = true
            "turnOff" -> status = false
        }
    }

    fun generatePowerUsing() {
    }
}







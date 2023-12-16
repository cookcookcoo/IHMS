package com.example.store.device

import android.util.Log
import com.example.store.R
import com.example.store.controlcenter.Operation
import java.io.Serializable
import java.util.Date
import java.util.Timer
import java.util.TimerTask

open class Device(
    val deviceID: Int,
    var name: String = "",
    var imageID: Int = R.drawable.device_bedroomlight,
    var type: String = "Device",
) : Serializable {

    var status: Boolean = false
    var availableOperations = mutableListOf<AvailableOperation>(
        AvailableOperation("TurnOn", listOf(0)),
        AvailableOperation("TurnOff", listOf(0))
    )

    var currentPower = 0
    var minPower = 0
    var maxPower = 0

    init {
        val random = java.util.Random()
        Timer().schedule(object : TimerTask() {
            override fun run() {
                currentPower = random.nextInt(maxPower - minPower + 1) + minPower
//                Log.d("Device", "$deviceID $name Power Changed, now is $currentPower .")
            }
        }, Date(), 3000)
    }


    open fun changeOperation(operation: String, para: Int) {

    }

    fun generatePowerUsing() {
    }
}







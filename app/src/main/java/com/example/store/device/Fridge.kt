package com.example.store.device

import com.example.store.controlcenter.Operation

class Fridge(deviceID: Int, name:String, var temperature:Int) : Device(deviceID,name) {
    fun changeTemp(temp: Int) {
        this.temperature = temp
    }


    override fun changeOperation(operation: Operation) {
        when (operation.operation) {
            "turnOn" -> status = true
            "turnOff" -> status = false
            "changeTemp" -> changeTemp(operation.para)
        }
    }
}
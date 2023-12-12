package com.example.store.device

import com.example.store.controlcenter.Operation

class Television(deviceID: Int, name:String, var channel:Int = 1) : Device(deviceID,name) {
    fun changeChannel(channel:Int) {
        this.channel = channel
    }

    override fun changeOperation(operation: Operation) {
        super.changeOperation(operation)
        when (operation.operation) {
            "ChangeChannel" -> changeChannel(operation.para)
        }
    }
}
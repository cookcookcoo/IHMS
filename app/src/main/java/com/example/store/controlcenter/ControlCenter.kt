package com.example.store.controlcenter

import android.util.Log
import com.example.store.device.Device



class ControlCenter(val user: User, val deviceList: ArrayList<Device>, val ruleList:ArrayList<Rule>) {

    fun addDevice() {

    }

    fun removeDevice() {

    }

    fun addRule() {

    }

    fun executeRule(rule: Rule) {
        val operationList = rule.operationList
        for (operation in operationList) {
            for (device in deviceList) {
                if (operation.deviceID == device.deviceID) {
                    device.changeOperation(operation)
                    Log.d("app",operation.deviceID.toString() + operation.operation + operation.para.toString())
                }
            }
        }
    }

    fun removeRule() {

    }

    fun getEnergyUsing() {

    }

    fun getEnergyUsage(): String {
        val stringBuffer = StringBuffer()
        for (device in deviceList) {
//            stringBuffer.append(device.deviceID.toString() + device.name + device.energyUsage.toString() + "\n")
        }
        return stringBuffer.toString()
    }

    fun userHealthTracing() {

    }

    fun ecoRecommendation() {

    }


}





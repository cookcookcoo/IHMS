package com.example.store.controlcenter

import android.util.Log
import com.example.store.device.AirConditioner
import com.example.store.device.Device
import com.example.store.device.Fridge
import com.example.store.device.Light
import com.example.store.device.Television
import kotlin.math.log


class ControlCenter(val user: User, val deviceList: ArrayList<Device>, val ruleList:ArrayList<Rule>) {
    init {
        initSampleCC()
    }

    var deviceID = 20000 + 6
    fun addDevice(deviceType:String, deviceName:String):String {
        lateinit var newDevice: Device
        when (deviceType) {
            "Light" -> newDevice = Light(deviceID, deviceName)
            "Air Conditioner" -> newDevice = AirConditioner(deviceID, deviceName)
            "Fridge" -> newDevice = Fridge(deviceID, deviceName)
            "Television" -> newDevice = Television(deviceID, deviceName)
        }
        deviceList.add(newDevice)
        deviceID += 1
        Log.d("CC", deviceList.size.toString())
        Log.d("CC", deviceID.toString())
        return "Success."
    }

    fun removeDevice(removeID:Int) {
        for (device in deviceList) {
            if (device.deviceID == removeID) {
                deviceList.remove(device)
                Log.d("CC", "$removeID remove success.")
                return
            }
        }
        Log.d("CC", "Failed to remove.")
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

    fun getPowerConsumption(): Int {
        var powerConsumptionSum = 0
        for (device in deviceList) {
            powerConsumptionSum += device.currentPower
        }
        Log.d("CC", "The total power is $powerConsumptionSum")
        return powerConsumptionSum
    }

    fun userHealthTracing() {

    }

    fun ecoRecommendation() {

    }


}





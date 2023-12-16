package com.example.store.controlcenter

import android.util.Log
import com.example.store.device.AirConditioner
import com.example.store.device.Curtain
import com.example.store.device.Device
import com.example.store.device.Fan
import com.example.store.device.Fridge
import com.example.store.device.Light
import com.example.store.device.Television
import kotlin.math.log


class ControlCenter(
    val user: User,
    val deviceList: ArrayList<Device>,
    val ruleList: ArrayList<Rule>
) {
    init {
        initSampleCC()
        initPostList()
    }

    var deviceID = 20000 + 8
    var ruleID = 30000+4
    fun addDevice(deviceType: String, deviceName: String): String {
        val newDevice: Device = when (deviceType) {
            "Light" -> Light(deviceID, deviceName)
            "Air Conditioner" -> AirConditioner(deviceID, deviceName)
            "Fridge" -> Fridge(deviceID, deviceName)
            "Television" -> Television(deviceID, deviceName)
            "Curtain" -> Curtain(deviceID, deviceName)
            "Fan" -> Fan(deviceID, deviceName)
            else -> throw IllegalArgumentException("Unknown device type")
        }
        deviceList.add(newDevice)
        deviceID += 1
        return "Success."
    }


    fun removeDevice(removeID: Int) {
        for (device in deviceList) {
            if (device.deviceID == removeID) {
                deviceList.remove(device)
                Log.d("CC", "$removeID remove success.")
                return
            }
        }
        Log.d("CC", "Failed to remove.")
    }

    fun getDevice(getID:Int) :Device{
        for (device in deviceList) {
            if (device.deviceID == getID) {
                return device
            }
        }
        return Device(20000, "False Device")
    }

    fun addRule(name:String, operationList: ArrayList<Operation>) {
        val newRule = Rule(ruleID, name, operationList)
        ruleList.add(newRule)
        ruleID += 1
    }

    fun executeRule(rule: Rule) {
        rule.execute()
    }


    fun removeRule() {

    }

    fun getRule(getID: Int):Rule {
        for (rule in ruleList) {
            if (getID == rule.ruleID) {
                return rule
            }
        }
        return Rule(30000, "False Rule", ArrayList<Operation>())
    }

    fun getEnergyUsing() {

    }

    fun getPowerConsumption(): Int {
        var powerConsumptionSum = 0
        for (device in deviceList) {
            powerConsumptionSum += device.currentPower
        }
//        Log.d("CC", "The total power is $powerConsumptionSum")
        return powerConsumptionSum
    }

    fun userHealthTracing() {

    }

    fun ecoRecommendation() {

    }


}





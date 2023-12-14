package com.example.store.controlcenter

import android.util.Log
import com.example.store.device.AirConditioner
import com.example.store.device.Curtain
import com.example.store.device.Device
import com.example.store.device.Fan
import com.example.store.device.Fridge
import com.example.store.device.Light
import com.example.store.device.Television

val light1 = Light(20001, "light1")
val light2 = Light(20002, "light2")
val airConditioner = AirConditioner(20003, "Air1")
val fridge = Fridge(20004, "Fridge1")
val television = Television(20005, "TV1")
val curtain = Curtain(20006, "Curtain1")
val fan = Fan(20007, "Fan1")


val sampleUser = User(10001, "sample user", "China")
val sampleDeviceList = ArrayList<Device>()
val sampleOperationList = ArrayList<Operation>()
val sampleRuleList = ArrayList<Rule>()
val sampleCC = ControlCenter(sampleUser, sampleDeviceList, sampleRuleList)


fun initDevice(deviceList: ArrayList<Device>) {
    deviceList.apply {
        add(light1)
        add(light2)
        add(airConditioner)
        add(fridge)
        add(television)
        add(curtain)
        add(fan)
    }
}

fun initOperation(operationList: ArrayList<Operation>) {
    operationList.add(Operation(light1, "TurnOn", 0))
    operationList.add(Operation(light2, "TurnOn", 0))
    operationList.add(Operation(airConditioner, "TurnOn", 0))
    operationList.add(Operation(airConditioner, "ChangeTemp", 22))
    operationList.add(Operation(television, "ChangeChannel", 32))
}


fun initRuleList(ruleList: ArrayList<Rule>) {
    ruleList.apply {
        add(Rule(30001, "Sample Rule", sampleOperationList))
        add(Rule(30002, "Turn On", sampleOperationList))
        add(Rule(30003, "Turn Off", sampleOperationList))
    }
}

fun initSampleCC() {
    initDevice(sampleDeviceList)
    initOperation(sampleOperationList)
    initRuleList(sampleRuleList)
    Log.d("CC", "initSampleCC")
}



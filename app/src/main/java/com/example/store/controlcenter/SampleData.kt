package com.example.store.controlcenter

import android.util.Log
import com.example.store.device.AirConditioner
import com.example.store.device.Curtain
import com.example.store.device.Device
import com.example.store.device.Fan
import com.example.store.device.Fridge
import com.example.store.device.Light
import com.example.store.device.Television

val sampleUser = User(10001, "sample user", "China")
val sampleDeviceList = ArrayList<Device>()
val sampleOperationList = ArrayList<Operation>()
val sampleRuleList = ArrayList<Rule>()
val sampleCC = ControlCenter(sampleUser, sampleDeviceList, sampleRuleList)

fun initDevice(deviceList: ArrayList<Device>) {
    deviceList.apply {
        add(Light(20001, "light1"))
        add(Light(20002, "light2"))
        add(AirConditioner(20003, "Air1"))
        add(Fridge(20004, "Fridge1"))
        add(Television(20005, "TV1"))
        add(Curtain(20006, "Curtain1"))
        add(Fan(20007, "Fan1"))
    }
}

fun initOperation(operationList: ArrayList<Operation>) {
    operationList.add(Operation(20001, "turnOn", 0))
    operationList.add(Operation(20002, "turnOn", 0))
    operationList.add(Operation(20003, "turnOn", 0))
    operationList.add(Operation(20003, "changeTemp", 22))
}

fun initSampleCC() {
    initDevice(sampleDeviceList)
    initOperation(sampleOperationList)
    sampleRuleList.apply {
        add(Rule(30001, "Sample Rule", sampleOperationList))
        add(Rule(30002, "Turn On", sampleOperationList))
        add(Rule(30003, "Turn Off", sampleOperationList))
    }
    Log.d("CC", "initSampleCC")
}



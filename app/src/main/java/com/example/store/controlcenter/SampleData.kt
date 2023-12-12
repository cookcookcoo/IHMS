package com.example.store.controlcenter

import com.example.store.device.AirConditioner
import com.example.store.device.Device
import com.example.store.device.Light

val sampleUser = User(10001, "sample user", "China")
val sampleDeviceList = ArrayList<Device>()
val sampleOperationList = ArrayList<Operation>()
val sampleRuleList = ArrayList<Rule>()

fun initDevice(deviceList: ArrayList<Device>) {
    deviceList.add(Light(20001, "light1"))
    deviceList.add(Light(20002, "light2"))
    deviceList.add(AirConditioner(20003, "Air1"))
}

fun initOperation(operationList:ArrayList<Operation>) {
    operationList.add(Operation(20001, "turnOn", 0))
    operationList.add(Operation(20002, "turnOn", 0))
    operationList.add(Operation(20003, "turnOn", 0))
    operationList.add(Operation(20003, "changeTemp", 22))
}

fun main() {
    initDevice(sampleDeviceList)
    initOperation(sampleOperationList)
    sampleRuleList.add(Rule(30001, "Sample Rule", sampleOperationList))
    val sampleCC = ControlCenter(sampleUser, sampleDeviceList, sampleRuleList)
}


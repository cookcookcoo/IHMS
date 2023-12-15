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
val sampleOperationList1 = ArrayList<Operation>()
val sampleOperationList2 = ArrayList<Operation>()
val sampleOperationList3 = ArrayList<Operation>()
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

fun initOperation2(operationList: ArrayList<Operation>) {
    operationList.apply {
        add((Operation(light1, "TurnOn", 0)))
        add((Operation(light2, "TurnOn", 0)))
        add((Operation(airConditioner, "TurnOn", 0)))
        add((Operation(fridge, "TurnOn", 0)))
        add((Operation(television, "TurnOn", 0)))
        add((Operation(curtain, "TurnOn", 0)))
        add((Operation(fan, "TurnOn", 0)))
    }
}

fun initOperation3(operationList: ArrayList<Operation>) {
    operationList.apply {
        add((Operation(light1, "TurnOff", 0)))
        add((Operation(light2, "TurnOff", 0)))
        add((Operation(airConditioner, "TurnOff", 0)))
        add((Operation(fridge, "TurnOff", 0)))
        add((Operation(television, "TurnOff", 0)))
        add((Operation(curtain, "TurnOff", 0)))
        add((Operation(fan, "TurnOff", 0)))
    }
}


fun initRuleList(ruleList: ArrayList<Rule>) {
    ruleList.apply {
        add(Rule(30001, "Sample Rule", sampleOperationList1))
        add(Rule(30002, "Turn On", sampleOperationList2))
        add(Rule(30003, "Turn Off", sampleOperationList3))
    }
}

fun initSampleCC() {
    initDevice(sampleDeviceList)
    initOperation(sampleOperationList1)
    initOperation2(sampleOperationList2)
    initOperation3(sampleOperationList3)
    initRuleList(sampleRuleList)
    Log.d("CC", "initSampleCC")
}



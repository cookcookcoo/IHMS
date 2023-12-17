package com.example.store.controlcenter

import android.util.Log
import com.example.store.device.AirConditioner
import com.example.store.device.Curtain
import com.example.store.device.Device
import com.example.store.device.Fan
import com.example.store.device.Fridge
import com.example.store.device.Light
import com.example.store.device.Television
import com.example.store.forum.Post

val light1 = Light(20001, "light1")
val light2 = Light(20002, "light2")
val airConditioner = AirConditioner(20003, "Air1")
val fridge = Fridge(20004, "Fridge1")
val television = Television(20005, "New TV")
val curtain = Curtain(20006, "My Curtain")
val fan = Fan(20007, "Fast Fan")


val userList = mutableMapOf<String, String>()


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
//        add(light2)
        add(airConditioner)
        add(fridge)
        add(television)
        add(curtain)
        add(fan)
    }
}

fun initOperation(operationList: ArrayList<Operation>) {
    operationList.add(Operation(light1, "TurnOn", 0))
//    operationList.add(Operation(light2, "TurnOn", 0))
    operationList.add(Operation(airConditioner, "TurnOn", 0))
    operationList.add(Operation(airConditioner, "ChangeTemp", 22))
//    operationList.add(Operation(television, "ChangeChannel", 32))
}

fun initOperation2(operationList: ArrayList<Operation>) {
    operationList.apply {
        add((Operation(light1, "TurnOn", 0)))
//        add((Operation(light2, "TurnOn", 0)))
        add((Operation(airConditioner, "TurnOn", 0)))
        add((Operation(fridge, "TurnOn", 0)))
//        add((Operation(television, "TurnOn", 0)))
//        add((Operation(curtain, "TurnOn", 0)))
//        add((Operation(fan, "TurnOn", 0)))
    }
}

fun initOperation3(operationList: ArrayList<Operation>) {
    operationList.apply {
        add((Operation(light1, "TurnOff", 0)))
//        add((Operation(light2, "TurnOff", 0)))
        add((Operation(airConditioner, "TurnOff", 0)))
        add((Operation(fridge, "TurnOff", 0)))
//        add((Operation(television, "TurnOff", 0)))
//        add((Operation(curtain, "TurnOff", 0)))
//        add((Operation(fan, "TurnOff", 0)))
    }
}


fun initRuleList(ruleList: ArrayList<Rule>) {
    ruleList.apply {
        add(Rule(30001, "Sample Rule", sampleOperationList1))
        add(Rule(30002, "Turn On", sampleOperationList2))
        add(Rule(30003, "Turn Off", sampleOperationList3))
    }
}

fun initPostList() {
    Post.apply {
        addPost(
            "《原》",
            "你说的对，但是《原神》是由米哈游自主研发的一款全新开放世界冒险游戏。游戏发生在一个被称作「提瓦特」的幻想世界，在这里，被神选中的人将被授予「神之眼」，导引元素之力。你将扮演一位名为「旅行者」的神秘角色，在自由的旅行中邂逅性格各异、能力独特的同伴们，和他们一起击败强敌，找回失散的亲人——同时，逐步发掘「原神」的真相。\n"
        )
        addPost(
            "Key of values",
            "Once upon a time in a bustling city, there lived a curious young girl named Lily. She loved exploring and discovering new things. One day, while wandering in a park, she stumbled upon an old, dusty book hidden under a pile of leaves.\n" +
                    "\n" +
                    "Intrigued, Lily opened the book to find a map with peculiar markings. It seemed to lead to a hidden treasure. Excited by the prospect of adventure, she decided to follow the map.\n" +
                    "\n" +
                    "The journey took her through dense forests, across a flowing river, and finally to a clearing where an ancient oak tree stood tall. Beneath it, she found a small chest filled with sparkling jewels and an old note.\n" +
                    "\n" +
                    "The note read, \"The greatest treasure is not what you find, but the journey it takes you on.\"\n" +
                    "\n" +
                    "With a smile, Lily realized the true meaning behind those words. The treasure wasn't just the jewels; it was the thrill of exploration and the lessons learned along the way. She carried this newfound wisdom back home, cherishing the adventure forever."
        )
        addPost(
            "Fox and Sparrow",
            "In a quiet village, a lone fox befriended a lost sparrow. Together, they taught each other about freedom and the beauty of unexpected friendships, creating their own small world within the vastness around them."
        )
    }
}

fun initUserList() {
    userList["CPZ"] = "cpz123123"
}

fun initSampleCC() {
    initDevice(sampleDeviceList)
    initOperation(sampleOperationList1)
    initOperation2(sampleOperationList2)
    initOperation3(sampleOperationList3)
    initRuleList(sampleRuleList)
    initUserList()
    Log.d("CC", "initSampleCC")
}



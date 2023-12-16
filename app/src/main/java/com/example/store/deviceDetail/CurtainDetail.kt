package com.example.store.deviceDetail

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.store.R
import com.example.store.controlcenter.Operation
import com.example.store.controlcenter.sampleCC
import com.example.store.device.Curtain
import com.google.android.material.appbar.CollapsingToolbarLayout

class CurtainDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curtain_detail)

        val layout: CollapsingToolbarLayout = findViewById(R.id.curtainDetailLayout)


        val curtainID = intent.getSerializableExtra("deviceID") as Int
        val curtain = sampleCC.getDevice(curtainID) as Curtain

        val switch: Switch = findViewById(R.id.curtainDetailSwitch)
        val ratioGroup: RadioGroup = findViewById(R.id.curtainRadioGroup)
        val opGroup = ArrayList<RadioButton>()

        opGroup.apply {
            add(findViewById(R.id.curtainOp1))
            add(findViewById(R.id.curtainOp2))
            add(findViewById(R.id.curtainOp3))
            add(findViewById(R.id.curtainOp4))
            add(findViewById(R.id.curtainOp5))
            add(findViewById(R.id.curtainOp6))
        }

        layout.title = curtain.name
        switch.isChecked = curtain.status
        opGroup[curtain.openingRate].isChecked = true

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Operation(curtain, "TurnOn", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${curtain.deviceID} turnOn",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Operation(curtain, "TurnOff", 0).run()
                Toast.makeText(
                    buttonView.context,
                    "${curtain.deviceID} turnOff",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        ratioGroup.setOnCheckedChangeListener { group, checkedID ->
            when (checkedID) {
                R.id.curtainOp1 -> Operation(curtain, "ChangeOpeningRate", 0).run()
                R.id.curtainOp2 -> Operation(curtain, "ChangeOpeningRate", 1).run()
                R.id.curtainOp3 -> Operation(curtain, "ChangeOpeningRate", 2).run()
                R.id.curtainOp4 -> Operation(curtain, "ChangeOpeningRate", 3).run()
                R.id.curtainOp5 -> Operation(curtain, "ChangeOpeningRate", 4).run()
                R.id.curtainOp6 -> Operation(curtain, "ChangeOpeningRate", 5).run()
                else -> {}
            }
        }


        //        启用导航栏的返回键

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 启用返回按钮
        supportActionBar?.setDisplayShowHomeEnabled(true) // 显示返回按钮

        // 设置导航按钮点击监听
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }
}
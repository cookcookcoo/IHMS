package com.example.store

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store.controlcenter.sampleCC
import java.util.Timer
import java.util.TimerTask

class RealTimePowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_real_time_power)

        val text = findViewById<TextView>(R.id.textView10)
        text.text = sampleCC.getPowerConsumption().toString()



        val realtimeLineChart = findViewById<RealtimeLineChartView>(R.id.realtimeLineChart)

        // 示例：定时添加随机数据
        val timer = Timer()
        val scaleFactor = 0.5 // 调整这个值以适应你的需求
        val maxValue = 100.0 // 根据你的实际数据范围调整
        val minValue = 0.0 // 根据你的实际数据范围调整


        val deviceList = sampleCC.deviceList
        var sortedDeviceList = ArrayList(deviceList.sortedByDescending { it.currentPower })
        val recycleView:RecyclerView = findViewById<RecyclerView>(R.id.realtimePowerRecycle)
        val layoutManager = LinearLayoutManager(this)
        recycleView?.layoutManager = layoutManager
        val adapter = RealtimePowerAdapter(sortedDeviceList)
        recycleView?.adapter = adapter

        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val powerConsumption = sampleCC.getPowerConsumption().toFloat()
                    val processedData = (powerConsumption * scaleFactor).coerceIn(minValue, maxValue).toFloat()
                    realtimeLineChart.addDataPoint(processedData)
                    text.text = "total power consumption：" + sampleCC.getPowerConsumption().toString() + "w"
                    sortedDeviceList = ArrayList(deviceList.sortedByDescending { it.currentPower })
                    adapter.notifyDataSetChanged()
                }
            }
        }, 0, 1000) // 每秒添加一个数据点

        //返回键
        val backButton = findViewById<ImageView>(R.id.imageView9)
        backButton.setOnClickListener {
            finish()
        }
    }
}
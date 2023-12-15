package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.store.controlcenter.sampleCC
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class RealTimePowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_real_time_power)

        val text = findViewById<TextView>(R.id.textView10)
        text.setText(sampleCC.getPowerConsumption().toString())

        Timer().schedule(object: TimerTask(){
            override fun run() {
                runOnUiThread{
                    text.setText("total power consumption：" + sampleCC.getPowerConsumption().toString())
                }
            }
        }, Date(), 3000)

        val realtimeLineChart = findViewById<RealtimeLineChartView>(R.id.realtimeLineChart)

        // 示例：定时添加随机数据
        val timer = Timer()
        val scaleFactor = 0.5 // 调整这个值以适应你的需求
        val maxValue = 100.0 // 根据你的实际数据范围调整
        val minValue = 0.0 // 根据你的实际数据范围调整
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val powerConsumption = sampleCC.getPowerConsumption().toFloat()
                    val processedData = (powerConsumption * scaleFactor).coerceIn(minValue, maxValue).toFloat()
                    realtimeLineChart.addDataPoint(processedData)
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
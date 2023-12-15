package com.example.store

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RealtimeLineChartView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val linePaint: Paint = Paint()
    private val axisPaint: Paint = Paint()
    private val textPaint: Paint = Paint()
    private val dataPoints = mutableListOf<Float>()

    init {
        linePaint.color = Color.BLUE
        linePaint.strokeWidth = 4f
        linePaint.style = Paint.Style.STROKE

        axisPaint.color = Color.BLACK
        axisPaint.strokeWidth = 2f

        textPaint.color = Color.BLACK
        textPaint.textSize = 30f
    }

    fun addDataPoint(value: Float) {
        dataPoints.add(value)
        // 控制数据点数量，避免过多导致图表不易观察
        if (dataPoints.size > MAX_DATA_POINTS) {
            dataPoints.removeAt(0)
        }
        invalidate() // 请求重绘
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.WHITE)

        // 绘制坐标轴
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), height.toFloat(), axisPaint) // x轴
        canvas?.drawLine(0f, 0f, 0f, height.toFloat(), axisPaint) // y轴

        // 绘制箭头
        canvas?.drawLine(width.toFloat(), height.toFloat(), width.toFloat() - 20f, height.toFloat() - 10f, axisPaint) // x轴箭头1
        canvas?.drawLine(width.toFloat(), height.toFloat(), width.toFloat() - 20f, height.toFloat() + 10f, axisPaint) // x轴箭头2
        canvas?.drawLine(0f, 0f, 10f, 0f, axisPaint) // y轴箭头1
        canvas?.drawLine(0f, 0f, 10f, 0f, axisPaint) // y轴箭头2

        // 绘制坐标轴刻度值和刻度线
        for (i in 0 until MAX_DATA_POINTS) {
            val x = i * (width / (MAX_DATA_POINTS - 1)).toFloat()
            canvas?.drawText("${i * 2}s", x, height + 40f, textPaint) // x轴刻度值（每个点代表2秒）
        }

        for (i in 0 until MAX_CHART_VALUE + 1 step 10) {
            val y = (height - i * height / MAX_CHART_VALUE).toFloat()
            canvas?.drawText("${i * 2}W", 10f, y, textPaint) // y轴刻度值
            canvas?.drawLine(0f, y, width.toFloat(), y, axisPaint) // y轴刻度线
        }

        // 绘制曲线
        for (i in 1 until dataPoints.size) {
            val startX = (i - 1) * (width / (MAX_DATA_POINTS - 1)).toFloat()
            val startY = height - dataPoints[i - 1] * height / MAX_CHART_VALUE
            val endX = i * (width / (MAX_DATA_POINTS - 1)).toFloat()
            val endY = height - dataPoints[i] * height / MAX_CHART_VALUE

            canvas?.drawLine(startX, startY, endX, endY, linePaint)
        }
    }

    companion object {
        const val MAX_DATA_POINTS = 50 // 控制最大数据点数量
        const val MAX_CHART_VALUE = 100 // 控制图表的最大值
    }
}

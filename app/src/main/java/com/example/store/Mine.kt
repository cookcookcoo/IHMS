package com.example.store

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class Mine : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_mine, container, false)

        val avator = rootView.findViewById<ImageView>(R.id.imageView3)
        avator.alpha = 0.7f
        //实时功率图
        val CardView2 = rootView.findViewById<CardView>(R.id.RealTimePowerActivity)
        CardView2.alpha = 0.7f
        CardView2.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, RealTimePowerActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        //用电建议
        val CardView3 = rootView.findViewById<CardView>(R.id.PowerAdviceActivity)
        CardView3.alpha = 0.7f
        CardView3.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, PowerAdviceActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        //健康咨询
        val CardView4 = rootView.findViewById<CardView>(R.id.HealthConsultationActivity)
        CardView4.alpha = 0.7f
        CardView4.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, HealthConsultationActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        //论坛
        val CardView5 = rootView.findViewById<CardView>(R.id.ForumActivity)
        CardView5.alpha = 0.7f
        CardView5.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, ForumActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        return rootView
    }

    companion object {

    }


}
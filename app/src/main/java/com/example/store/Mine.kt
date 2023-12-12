package com.example.store

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Mine.newInstance] factory method to
 * create an instance of this fragment.
 */
class Mine : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_mine, container, false)
        //我的详情
        val CardView1 = rootView.findViewById<ImageView>(R.id.imageView3)
        CardView1.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, MyDetailsActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        //实时功率图
        val CardView2 = rootView.findViewById<CardView>(R.id.RealTimePowerActivity)
        CardView1.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, MyDetailsActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        //用电建议
        val CardView3 = rootView.findViewById<CardView>(R.id.PowerAdviceActivity)
        CardView1.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, MyDetailsActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        //健康咨询
        val CardView4 = rootView.findViewById<CardView>(R.id.HealthConsultationActivity)
        CardView1.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, MyDetailsActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        //论坛
        val CardView5 = rootView.findViewById<CardView>(R.id.ForumActivity)
        CardView1.setOnClickListener{
            // 创建一个Intent并指定目标Activity
            val intent = Intent(activity, MyDetailsActivity::class.java)
            // 启动目标Activity
            startActivity(intent)
        }
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Mine.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Mine().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
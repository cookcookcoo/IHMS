package com.example.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store.controlcenter.sampleCC

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DevicesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DevicesFragment : Fragment() {
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

    private lateinit var cardTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // 初始化TextView

        return inflater.inflate(R.layout.devices_frag, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DevicesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DevicesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    // 更新数据的方法
//    fun updateData(selectedOption: String, userInput: String) {
//        // 在这里处理从弹窗中得到的数据
//        // 例如，将数据打印到卡片上
//        val newData = "Selected Option: $selectedOption\nUser Input: $userInput"
//        cardTextView.text = newData
//    }

    override fun onResume() {
        super.onResume()
        val deviceList = sampleCC.deviceList


        val layoutManager = GridLayoutManager(this.context, 2)
        val recycleView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        recycleView?.layoutManager = layoutManager
        val adapter = DeviceAdapter(deviceList)
        recycleView?.adapter = adapter


    }


}
package com.example.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Devices.newInstance] factory method to
 * create an instance of this fragment.
 */
class Devices : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    private fun replaceContentFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.contentContainer, fragment)
            .commit()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_devices, container, false)

        val DevicestextView = rootView.findViewById<TextView>(R.id.textView6)
        val SpacetextView = rootView.findViewById<TextView>(R.id.textView7)
        replaceContentFragment(DevicesFragment())

        DevicestextView.setOnClickListener{
            replaceContentFragment(DevicesFragment())
        }

        SpacetextView.setOnClickListener{
            replaceContentFragment(SpaceFragment())
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
         * @return A new instance of fragment Devices.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Devices().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
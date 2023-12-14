package com.example.store

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.store.deviceDetail.AirConditionerDetail
import com.example.store.deviceDetail.CurtainDetail
import com.example.store.deviceDetail.FanDetail
import com.example.store.deviceDetail.FridgeDetail
import com.example.store.deviceDetail.LightDetail
import com.example.store.deviceDetail.TelevisionDetail
import com.example.store.controlcenter.Operation
import com.example.store.device.AirConditioner
import com.example.store.device.Curtain
import com.example.store.device.Device
import com.example.store.device.Fan
import com.example.store.device.Fridge
import com.example.store.device.Light
import com.example.store.device.Television

class DeviceAdapter(private val deviceList: ArrayList<Device>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.device_item, parent, false)


        return DeviceViewHolder(view)
    }

    override fun getItemCount() = deviceList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val device = deviceList[position]

        if (holder is DeviceViewHolder) {
            holder.bind(device)
        }
    }


    inner class DeviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val deviceName: TextView = itemView.findViewById(R.id.deviceName)
        private val deviceImage: ImageView = itemView.findViewById(R.id.deviceImage)
        private val deviceSwitch: Switch = itemView.findViewById(R.id.deviceSwitch)

        fun bind(device: Device) {
            deviceName.text = device.name
            deviceImage.setImageResource(device.imageID)
            deviceSwitch.isChecked = device.status

            deviceSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    Operation(device, "TurnOn", 0).run()
                    Toast.makeText(
                        buttonView.context,
                        "${device.deviceID} turnOn",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Operation(device, "TurnOff", 0).run()
                    Toast.makeText(
                        buttonView.context,
                        "${device.deviceID} turnOff",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            itemView.setOnClickListener {
                handleItemClick(itemView.context, device)
            }
        }
    }

    private fun handleItemClick(context: Context, device: Device) {


        val intent = when (device) {
            is Light -> Intent(context, LightDetail::class.java)
            is Television -> Intent(context, TelevisionDetail::class.java)
            is AirConditioner -> Intent(context, AirConditionerDetail::class.java)
            is Curtain -> Intent(context, CurtainDetail::class.java)
            is Fridge -> Intent(context, FridgeDetail::class.java)
            is Fan -> Intent(context, FanDetail::class.java)
            else -> throw IllegalArgumentException("Unknown device type")
        }

        intent.putExtra("device", device)
        context.startActivity(intent)
    }

}
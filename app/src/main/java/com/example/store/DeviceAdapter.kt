package com.example.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.store.controlcenter.Operation
import com.example.store.device.Device

class DeviceAdapter(val deviceList: ArrayList<Device>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deviceName: TextView = view.findViewById(R.id.deviceName)
        val deviceImage:ImageView = view.findViewById(R.id.deviceImage)
        val deviceSwitch: Switch = view.findViewById(R.id.deviceSwitch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.device_item, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val device = deviceList[position]
            holder.deviceName.text = device.name
            holder.deviceImage.setImageResource(device.imageID)
            holder.deviceSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        device.changeOperation(Operation(device.deviceID, "turnOn", 0))
                        Toast.makeText(buttonView.context, "${device.deviceID} turnOn", Toast.LENGTH_SHORT).show()
                    } else {
                        device.changeOperation(Operation(device.deviceID, "turnOff", 0))
                        Toast.makeText(buttonView.context, "turnOff", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }


    override fun getItemCount() = deviceList.size

}
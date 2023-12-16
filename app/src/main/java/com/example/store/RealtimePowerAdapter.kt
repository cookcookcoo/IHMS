package com.example.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.device.Device

class RealtimePowerAdapter(private val deviceList: ArrayList<Device>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.realtime_power_item, parent, false)


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
        private val powerDetail: TextView = itemView.findViewById(R.id.powerItemText)
        fun bind(device: Device) {
            powerDetail.text = "${device.name}: ${device.currentPower}w"
        }
    }

}
package com.example.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.controlcenter.Operation

class OperationAdapter(private val operationList: ArrayList<Operation>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.operation_item, parent, false)
        return OperationViewHolder(view)
    }

    override fun getItemCount() = operationList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val operation = operationList[position]
        if (holder is OperationViewHolder) {
            holder.bind(operation)
        }
    }

    inner class OperationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val deviceImage:ImageView = itemView.findViewById(R.id.operationDeviceImage)
        private val operationDetail:TextView = itemView.findViewById(R.id.operationDetail)

        fun bind(operation: Operation) {
            val stringBuilder = StringBuilder()
            stringBuilder.apply {
                append(operation.device.deviceID)
                append(operation.device.name)
                append(operation.operation)
                append(operation.para)
            }

            deviceImage.setImageResource(operation.device.imageID)
            operationDetail.text = stringBuilder.toString()


        }
    }
}
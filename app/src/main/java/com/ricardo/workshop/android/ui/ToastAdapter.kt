package com.ricardo.workshop.android.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ricardo.workshop.android.R
import com.ricardo.workshop.android.common.CurrencyFormatter
import com.ricardo.workshop.android.common.DateTimeFormatter
import com.ricardo.workshop.android.data.Toast

internal class ToastAdapter : ListAdapter<Toast, ToastAdapter.ViewHolder>(ToastDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.toast, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val icon = itemView.findViewById<TextView>(R.id.icon)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val price = itemView.findViewById<TextView>(R.id.price)
        private val lastSold = itemView.findViewById<TextView>(R.id.last_sold)

        fun bind(toast: Toast) {
            icon.text = "${toast.id}"
            name.text = toast.name
            price.text = CurrencyFormatter.format(toast.currency, toast.price)
            lastSold.text = DateTimeFormatter.format(toast.lastSold)
        }
    }

    class ToastDiffCallback : DiffUtil.ItemCallback<Toast>() {
        override fun areItemsTheSame(oldItem: Toast, newItem: Toast): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Toast, newItem: Toast): Boolean {
            return oldItem == newItem
        }
    }
}

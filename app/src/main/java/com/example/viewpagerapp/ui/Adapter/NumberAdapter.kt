package com.example.viewpagerapp.ui.Adapter

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagerapp.R
import com.example.viewpagerapp.ui.Fragments.ARG_OBJECT



@Suppress("DEPRECATION")
class NumberAdapter(private var item: List<String>) :
    RecyclerView.Adapter<NumberAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.textView)
        val notificationButton: Button = itemView.findViewById(R.id.notification_button)

        init {
            notificationButton.setOnClickListener { v: View ->
                val position = adapterPosition
                val toast = Toast.makeText(
                    itemView.context,
                    "You created a notification ${position + 1}",
                    Toast.LENGTH_SHORT,
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): NumberAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_notification, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NumberAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = item[position]
    }

    override fun getItemCount(): Int {
        return item.size
    }
}
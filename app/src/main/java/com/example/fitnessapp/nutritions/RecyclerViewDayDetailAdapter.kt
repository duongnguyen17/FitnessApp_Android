package com.example.fitnessapp.nutritions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import com.example.fitnessapp.model.DayData

class RecyclerViewDayDetailAdapter(private val data: List<DayData>) :
    RecyclerView.Adapter<RecyclerViewDayDetailAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.day_detail_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textHeader: TextView = view.findViewById(R.id.tvDayNutrition)
        val imageView: ImageView = view.findViewById(R.id.ivDayNutrition)

        fun onBind(data: DayData) {
            textHeader.text = data.name
            imageView.setImageResource(data.imageUri)
        }
    }
}
package com.example.fitnessapp.nutritions


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import com.example.fitnessapp.model.DayData
import android.net.Uri


class RecycleViewDayAdapter(private val data: List<DayData>) :
    RecyclerView.Adapter<RecycleViewDayAdapter.ViewHolder>() {

    var listener: IItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])

        holder.itemView.setOnClickListener {
            listener?.onClickItem(data[position])
        }
//        holder.itemView.setOnLongClickListener {
//            listener?.onLongClickItem(data[position])
//        }
    }

    override fun getItemCount(): Int = data.size

    // inner class
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ivDayNutrition)
        val textView: TextView = view.findViewById(R.id.tvDayNutrition)
        fun onBind(data: DayData) {
//            imageView.setImageURI(Uri.parse(data.imageUri))

            textView.text = data.name
            imageView.setImageResource(data.imageUri)
        }
    }

    interface IItemListener {
        fun onClickItem(item: DayData)
//        fun onLongClickItem(item: DayData)
    }
}
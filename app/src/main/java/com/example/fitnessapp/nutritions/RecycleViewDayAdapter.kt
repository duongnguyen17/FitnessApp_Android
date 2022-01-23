package com.example.fitnessapp.nutritions


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import com.example.fitnessapp.model.DayData
import android.net.Uri
import androidx.cardview.widget.CardView


class RecycleViewDayAdapter(private val data: List<DayData>  ) :
    RecyclerView.Adapter<RecycleViewDayAdapter.ViewHolder>() {

    var listener: IItemListener? = null
    var clickedItemPosition: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position], position == clickedItemPosition)

        holder.itemView.setOnClickListener {
            listener?.onClickItem(data[position], position)
            this.notifyDataSetChanged()
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
        val cardView = view.findViewById<CardView>(R.id.cvDay)

        fun onBind(data: DayData, isClick: Boolean) {
//            imageView.setImageURI(Uri.parse(data.imageUri))
            if(isClick){cardView.setCardBackgroundColor(Color.parseColor("#806BF8"))}
            textView.text = data.name
            imageView.setImageResource(data.imageUri)
        }
    }

    interface IItemListener {
        fun onClickItem(item: DayData, position: Int)
//        fun onLongClickItem(item: DayData)
    }
}
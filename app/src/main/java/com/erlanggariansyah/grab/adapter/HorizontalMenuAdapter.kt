package com.erlanggariansyah.grab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erlanggariansyah.grab.R
import com.erlanggariansyah.grab.dto.HorizontalMenuItem

class HorizontalMenuAdapter(private val horizontalMenuItems: ArrayList<HorizontalMenuItem>): RecyclerView.Adapter<HorizontalMenuAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageItem)
        val titleView: TextView = itemView.findViewById(R.id.titleItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_horizontal_menu_item, parent, false))

    override fun getItemCount(): Int = horizontalMenuItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (imageId, title) = horizontalMenuItems[position]
        holder.imageView.setImageResource(imageId)
        holder.titleView.text = title
    }
}

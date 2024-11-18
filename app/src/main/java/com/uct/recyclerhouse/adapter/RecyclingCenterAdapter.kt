package com.uct.recyclerhouse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uct.recyclerhouse.databinding.ItemRecyclingCenterBinding
import com.uct.recyclerhouse.model.RecyclingCenter

class RecyclingCenterAdapter(private val centers: List<RecyclingCenter>) : RecyclerView.Adapter<RecyclingCenterAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemRecyclingCenterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(center: RecyclingCenter) {
            binding.centerName.text = center.name
            binding.centerDistance.text = center.distance
            binding.viewRouteButton.setOnClickListener {
                // Implementar la lógica para ver la ruta
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclingCenterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val center = centers[position]
        holder.bind(center)
    }

    override fun getItemCount() = centers.size
}

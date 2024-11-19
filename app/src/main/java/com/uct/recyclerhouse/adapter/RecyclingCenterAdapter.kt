package com.uct.recyclerhouse.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uct.recyclerhouse.databinding.ItemRecyclingCenterBinding
import com.uct.recyclerhouse.model.RecyclingCenter

class RecyclingCenterAdapter(
    private val centers: List<RecyclingCenter>
) : RecyclerView.Adapter<RecyclingCenterAdapter.CenterViewHolder>() {

    inner class CenterViewHolder(private val binding: ItemRecyclingCenterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(center: RecyclingCenter) {
            // Asignar datos al layout
            binding.centerName.text = center.name
            binding.centerDistance.text = center.distance
            binding.localImage.setImageResource(center.imageResId)

            // Configurar botón para abrir Google Maps
            binding.viewRouteButton.setOnClickListener {
                val context: Context = it.context
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(center.googleMapsLink))
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CenterViewHolder {
        val binding = ItemRecyclingCenterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CenterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CenterViewHolder, position: Int) {
        holder.bind(centers[position])
    }

    override fun getItemCount(): Int = centers.size
}

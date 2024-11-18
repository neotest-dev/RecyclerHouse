package com.uct.recyclerhouse.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.uct.recyclerhouse.databinding.ItemWasteTypeBinding
import com.uct.recyclerhouse.model.WasteType

class WasteTypeAdapter(
    private val context: Context?,
    private val wasteTypes: List<WasteType>
) :
    RecyclerView.Adapter<WasteTypeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemWasteTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wasteType: WasteType) {
            binding.wasteTypeIcon.setImageResource(wasteType.iconResId)
            binding.wasteTypeName.text = wasteType.name
            binding.wasteTypeDescription.text = wasteType.description
            binding.main.setOnClickListener {
                Toast.makeText(context, wasteType.name, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemWasteTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wasteTypes[position])
    }

    override fun getItemCount(): Int = wasteTypes.size
}

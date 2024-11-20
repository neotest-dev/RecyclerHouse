package com.uct.recyclerhouse.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uct.recyclerhouse.DetailActivity
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
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("MESSAGE_KEY", wasteType.name)
                context!!.startActivity(intent)
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

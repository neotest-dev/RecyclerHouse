package com.uct.recyclerhouse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uct.recyclerhouse.databinding.ItemEducationTipBinding

class EducationTipAdapter(
    private val tips: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<EducationTipAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemEducationTipBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tip: String, onClick: (String) -> Unit) {
            binding.tipText.text = tip
            binding.root.setOnClickListener {
                onClick(
                    tip
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemEducationTipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tip = tips[position]
        holder.bind(tip, onClick)
    }

    override fun getItemCount() = tips.size
}

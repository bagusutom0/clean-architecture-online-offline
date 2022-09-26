package com.latihan.latihanonlineoffline.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.latihan.latihanonlineoffline.core.domain.model.Fact
import com.latihan.latihanonlineoffline.databinding.ItemFactBinding

class FactAdapter(private val list: List<Fact>): RecyclerView.Adapter<FactAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactAdapter.ViewHolder {
        val binding = ItemFactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FactAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val binding: ItemFactBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(fact: Fact) {
            binding.tvFact.text = fact.fact
        }
    }
}
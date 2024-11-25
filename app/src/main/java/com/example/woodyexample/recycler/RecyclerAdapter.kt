package com.example.woodyexample.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.woodyexample.databinding.ViewUserInfoBinding

class RecyclerAdapter(
    private val items: List<User>,
    private val onClickListener: (User) -> Unit
): RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {


    class ItemViewHolder(val binding: ViewUserInfoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ViewUserInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.binding.userName.text = item.name
        holder.binding.ag.text = item.age
        holder.itemView.setOnClickListener { onClickListener(item) }
    }


    override fun getItemCount(): Int = items.size
}
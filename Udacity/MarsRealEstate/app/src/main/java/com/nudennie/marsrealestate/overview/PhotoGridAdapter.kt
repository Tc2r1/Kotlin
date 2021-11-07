package com.nudennie.marsrealestate.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.nudennie.marsrealestate.databinding.GridViewItemBinding
import com.nudennie.marsrealestate.network.MarsProperty
import com.nudennie.marsrealestate.overview.PhotoGridAdapter.MarsPropertyViewHolder

class PhotoGridAdapter : ListAdapter<MarsProperty, MarsPropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPropertyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MarsPropertyViewHolder(GridViewItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }

    class MarsPropertyViewHolder(private var binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsProperty) {
            binding.property = marsProperty

            // Updated the bound UI
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }
}





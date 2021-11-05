/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nudennie.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.nudennie.trackmysleepquality.*
import com.nudennie.trackmysleepquality.database.SleepNight
import com.nudennie.trackmysleepquality.databinding.ListItemSleepNightBinding
import com.nudennie.trackmysleepquality.sleeptracker.SleepNightAdapter.ViewHolder

class SleepNightAdapter : ListAdapter<SleepNight, ViewHolder>(SleepNightDiffCallback()) {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        return ViewHolder.from(parent = parent)
    }

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        val sleepNight = getItem(position)
        holder.bind(sleepNight)
    }

    class ViewHolder private constructor(val binding : ListItemSleepNightBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sleepNight : SleepNight) {
            binding.sleep = sleepNight
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent : ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem : SleepNight, newItem : SleepNight) : Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem : SleepNight, newItem : SleepNight) : Boolean {
        return oldItem == newItem
    }

}
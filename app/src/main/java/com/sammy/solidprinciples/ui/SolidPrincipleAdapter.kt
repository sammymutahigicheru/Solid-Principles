package com.sammy.solidprinciples.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sammy.solidprinciples.databinding.LayoutSolidPrincipleBinding
import com.sammy.solidprinciples.models.SolidPrinciple

class SolidPrincipleAdapter(
    private val onClick: (SolidPrinciple) -> Unit
) : ListAdapter<SolidPrinciple, SolidPrincipleAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(
        private val binding: LayoutSolidPrincipleBinding
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(item: SolidPrinciple) {
            binding.apply {
                solidPrincpleName.text = item.name
                solidPrincipleDescription.text = item.description
            }
        }

        override fun onClick(view: View) {
            val solidPrinciple = getItem(adapterPosition)
            onClick.invoke(solidPrinciple)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = LayoutSolidPrincipleBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<SolidPrinciple>() {
            override fun areItemsTheSame(
                oldItem: SolidPrinciple,
                newItem: SolidPrinciple
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: SolidPrinciple,
                newItem: SolidPrinciple
            ): Boolean {
                return oldItem.name == newItem.name && oldItem.description == newItem.description
            }

        }
    }
}
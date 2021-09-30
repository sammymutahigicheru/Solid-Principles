package com.sammy.solidprinciples.ui

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.sammy.solidprinciples.R
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
                expandArrow.setOnClickListener {
                    if (detailsLayout.isVisible){
                        TransitionManager.beginDelayedTransition(
                            cardView,
                            AutoTransition()
                        )
                        detailsLayout.visibility = GONE
                        expandArrow.setImageResource(R.drawable.ic_baseline_arrow_down_24)
                    }else {
                        TransitionManager.beginDelayedTransition(
                            cardView,
                            AutoTransition()
                        )
                        detailsLayout.visibility = VISIBLE
                        expandArrow.setImageResource(R.drawable.ic_baseline_arrow_up_24)
                    }
                }
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
        val binding = LayoutSolidPrincipleBinding.inflate(inflater,parent, false)
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
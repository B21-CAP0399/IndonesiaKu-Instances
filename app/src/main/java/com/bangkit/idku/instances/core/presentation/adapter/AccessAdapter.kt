package com.bangkit.idku.instances.core.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.idku.instances.R
import com.bangkit.idku.instances.core.domain.model.AccessPermission
import com.bangkit.idku.instances.databinding.LayoutItemAccessBinding

class AccessAdapter(
    private val onItemClick: () -> Unit
) : RecyclerView.Adapter<AccessAdapter.CardViewHolder>() {
    private val list: ArrayList<AccessPermission> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
        CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_access, parent, false)
        )

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding by lazy {
            LayoutItemAccessBinding.bind(itemView)
        }

        fun bind(permission: AccessPermission) = with(binding){

        }
    }

}
package com.example.project_api.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_api.R
import com.example.project_api.base.BaseViewHolder
import com.example.project_api.data.model.bebida
import kotlinx.android.synthetic.main.item_drink.view.*

class MainAdapter(
    private val context: Context,
    private val bebidaList: List<bebida>,
    private val itemClickListener: OnbebidaClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnbebidaClickListener {
        fun onbebidaClick(bebida: bebida)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_drink, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return bebidaList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(bebidaList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<bebida>(itemView) {
        override fun bind(item: bebida, position: Int) {
            Glide.with(context).load(item.image).into(itemView.img_bebida)
            itemView.txt_title.text = item.title
            itemView.txt_Describe.text = item.describe
            itemView.setOnClickListener { itemClickListener.onbebidaClick(item) }
        }
    }
}

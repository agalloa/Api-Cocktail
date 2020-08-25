package com.example.project_api.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_api.R
import com.example.project_api.base.BaseViewHolder
import com.example.project_api.data.model.bebida
import kotlinx.android.synthetic.main.bebida_row.view.*
import kotlinx.android.synthetic.main.fragment_main_.*

class MainAdapter(private val context: Context, private val bebidaList: List<bebida>, private val itemClickListener:OnbebidaClickListener):RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnbebidaClickListener{
        fun onbebidaClick(bebida: bebida)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.bebida_row, parent,false))
    }

    override fun getItemCount(): Int {
        return bebidaList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainViewHolder -> holder.bind(bebidaList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View): BaseViewHolder<bebida>(itemView){
        override fun bind(item: bebida, position: Int) {
            Glide.with(context).load(item.image).into(itemView.img_bebida)
            itemView.txt_title.text = item.title
            itemView.txt_Describe.text = item.describe
            itemView.setOnClickListener{itemClickListener.onbebidaClick(item)}
        }

    }
}

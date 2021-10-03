package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemsBinding


// Created dataAdaopter Class for RecycleViiewAdapter
//Added this comment to learn viewholder Concepts

class DataAdapter(private val names:List<RetrofitDemo>):RecyclerView.Adapter<DataAdapter.ViewHolder>()
{
 inner class ViewHolder(val myItemView:ListItemsBinding):RecyclerView.ViewHolder(myItemView.root){}

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
  return ViewHolder(DataBindingUtil.inflate<ListItemsBinding>(LayoutInflater.from(parent.context), R.layout.list_items,parent,false))
 }

 override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.myItemView.item.text=names.get(position).title
 }

 override fun getItemCount(): Int {
  return names.size
 }


}

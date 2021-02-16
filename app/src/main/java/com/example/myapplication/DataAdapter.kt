package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemsBinding

class DataAdapter(private val names:List<RetrofitDemo>):RecyclerView.Adapter<DataAdapter.ViewHolder>()
{
 inner class ViewHolder(val itemView:ListItemsBinding):RecyclerView.ViewHolder(itemView.root){}

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
  return ViewHolder(DataBindingUtil.inflate<ListItemsBinding>(LayoutInflater.from(parent.context), R.layout.list_items,parent,false))
 }

 override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.itemView.item.text=names.get(position).title
 }

 override fun getItemCount(): Int {
  return names.size
 }


}
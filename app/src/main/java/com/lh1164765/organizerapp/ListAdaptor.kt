package com.lh1164765.organizerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdaptor (val context : Context,
                   val lists : List<listData>
                   ) : RecyclerView.Adapter<ListAdaptor.ListViewHolder>(){


    inner class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val listName = itemView.findViewById<TextView>(R.id.listTextView)
        val listItems = itemView.findViewById<TextView>(R.id.listContentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = lists[position]
        with(holder){
            listName.text = list.listName
            for (item in list.listItems!!) {
                listItems.text = listItems.text.toString() + item + "\n"
            }
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}
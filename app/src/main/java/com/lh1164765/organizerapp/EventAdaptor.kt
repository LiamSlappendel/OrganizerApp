package com.lh1164765.organizerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdaptor (val context : Context,
val events : eventData
) : RecyclerView.Adapter<EventAdaptor.EventViewHolder>(){

    inner class EventViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val eventName = itemView.findViewById<TextView>(R.id.listTextView)
        val eventItems = itemView.findViewById<TextView>(R.id.listContentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events
        with(holder){
            eventName.text = event.eventName
            eventItems.text = event.eventDate + " - " + event.eventDetails
        }
    }

    override fun getItemCount(): Int {
        return 1
    }


}
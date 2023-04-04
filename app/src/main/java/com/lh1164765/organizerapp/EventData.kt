package com.lh1164765.organizerapp

data class eventData (
    var id: String? = null,
    var eventName: String? = null,
    var eventDate: String? = null,
    var eventDetails: String? = null,
    var uID: String? = null
)
{
    override
    fun toString(): String {
        if (eventDate != null) {
            return eventName.toString() + ": " +" - " + eventDetails.toString()
        }
        else {
            return "undefined"
        }
    }
}
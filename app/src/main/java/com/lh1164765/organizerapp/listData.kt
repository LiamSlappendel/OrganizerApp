package com.lh1164765.organizerapp

data class listData (
    var id: String? = null,
    var listName: String? = null,
    var listItems: ArrayList<String>? = null,
    var uID: String? = null
        )
{
    override
    fun toString(): String {
        if (listItems != null) {
            return listName.toString() + " " + listItems.toString()
        }
        else {
            return "undefined"
        }
    }

    //add in toString method to return a string of each item seperated by a line
    fun toStringItems(): String {
        if (listItems != null) {
            var items = ""
            for (item in listItems!!) {
                items += item + "\n"
            }
            return items
        }
        else {
            return "undefined"
        }
    }
}


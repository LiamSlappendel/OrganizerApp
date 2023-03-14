package com.lh1164765.organizerapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class ListViewModel : ViewModel() {
    private val lists = MutableLiveData<List<listData>>()

    init{
        val userID = Firebase.auth.currentUser?.uid

        val db = FirebaseFirestore.getInstance().collection("Lists")
            .whereEqualTo("uid", userID)
            .addSnapshotListener { documents, error ->
                if (error != null) {
                    Log.w("DB Issue", error.localizedMessage)
                    return@addSnapshotListener
                }

                documents?.let {
                    val listArray = ArrayList<listData>()
                    Log.i("DB Response", "Got ${documents.size()} documents")
                    for (document in documents) {
                        Log.i ("DB Response", "${document.data}")
                        val list = document.toObject(listData::class.java)
                        listArray.add(list)
                    }
                    lists.value = listArray
                }
            }



    }

    fun getLists() : LiveData<List<listData>> {
        return lists
    }

}
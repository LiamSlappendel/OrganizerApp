package com.lh1164765.organizerapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class EventViewModel : ViewModel() {
    private val events = MutableLiveData<eventData>()

    init{
        val userID = Firebase.auth.currentUser?.uid

        val db = FirebaseFirestore.getInstance().collection("Events")
            .whereEqualTo("uid", userID)
            .addSnapshotListener { documents, error ->
                if (error != null) {
                    Log.w("DB Issue", error.localizedMessage)
                    return@addSnapshotListener
                }

                documents?.let {
                    Log.i("DB Response", "Got ${documents.size()} documents")
                    for (document in documents) {
                        Log.i ("DB Response", "${document.data}")
                        val event = document.toObject(eventData::class.java)
                    }
                }
            }



    }

    fun getEvents() : MutableLiveData<eventData> {
        return events
    }

}
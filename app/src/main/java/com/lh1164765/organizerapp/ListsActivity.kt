package com.lh1164765.organizerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lh1164765.organizerapp.databinding.ActivityListsBinding

class ListsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListsBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        //listener for when home button is pressed, will open the main activity
        binding.homeButton1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.CreateListButton.setOnClickListener {
            var listName = binding.ListNameInput.text.toString()

            if (listName.isNotEmpty()) {
                val db = FirebaseFirestore.getInstance().collection("Lists")
                var currentUser = auth.currentUser!!.uid
                val id = db.document().id

                var list = listData(id, listName, ArrayList<String>() , currentUser)




                db.document(id).set(list)
                    .addOnSuccessListener {
                        Toast.makeText(this, "List created", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        exception -> Log.w("DB Issue", exception!!.localizedMessage)
                        Toast.makeText(this, "List creation failed", Toast.LENGTH_SHORT).show()
                    }

            }
            else
            {
                Toast.makeText(this, "Please enter a list name", Toast.LENGTH_SHORT).show()
            }
        }

        val viewModel : ListViewModel by viewModels()
        viewModel.getLists().observe(this, { lists ->
            binding.recyclerView.adapter = ListAdaptor(this, lists)
        })
    }
}

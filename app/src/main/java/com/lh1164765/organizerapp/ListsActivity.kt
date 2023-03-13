package com.lh1164765.organizerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lh1164765.organizerapp.databinding.ActivityListsBinding

class ListsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //listener for when home button is pressed, will open the main activity
        binding.homeButton1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.CreateListButton.setOnClickListener {
            var listName = binding.ListNameInput.text.toString()

            if (listName.isNotEmpty()) {
                var list = listData(listName, ArrayList<String>(), null)

            }
            else
            {
                Toast.makeText(this, "Please enter a list name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
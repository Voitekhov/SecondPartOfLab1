package com.example.secondpartoflab1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.secondpartoflab1.R
import com.example.secondpartoflab1.adapter.CustomDataAdapter
import com.example.secondpartoflab1.model.Subject

class TimeTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)
        val subjects = intent.extras?.get("subjects") as List<Subject>
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = CustomDataAdapter(subjects, this)
    }
}
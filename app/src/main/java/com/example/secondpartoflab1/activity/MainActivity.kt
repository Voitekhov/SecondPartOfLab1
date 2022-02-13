package com.example.secondpartoflab1.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondpartoflab1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showStudentTimeTable(view: android.view.View) {
        val intent = Intent(this, StudentActivity::class.java)
        startActivity(intent)
    }

    fun showTeacherTimeTable(view: android.view.View) {
        val intent = Intent(this, TeacherActivity::class.java)
        startActivity(intent)
    }
}
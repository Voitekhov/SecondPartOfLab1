package com.example.secondpartoflab1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.secondpartoflab1.R
import com.example.secondpartoflab1.model.*
import com.example.secondpartoflab1.util.getSubjectsForStudentDay
import com.example.secondpartoflab1.util.getSubjectsForTeacherDay
import com.example.secondpartoflab1.util.getSubjectsForTeacherWeek
import java.io.Serializable

class TeacherActivity : AppCompatActivity() {

    var selectedItem: Teacher? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)


        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = ArrayAdapter(
            this, R.layout.support_simple_spinner_dropdown_item,
            initTeacherList()
        )
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View?,
                selectedItemPosition: Int,
                selectedId: Long
            ) {
                selectedItem = parent?.getItemAtPosition(selectedItemPosition) as Teacher
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun showTimeTableForDay(view: android.view.View) {
        val intent = Intent(this, TimeTableActivity::class.java)
        intent.putExtra(
            "subjects", getSubjectsForTeacherDay(initSubjects(), selectedItem!!.id) as Serializable
        )
        startActivity(intent)
    }
    fun showTimeTableForWeek(view: android.view.View) {
        val intent = Intent(this, TimeTableActivity::class.java)
        intent.putExtra(
            "subjects", getSubjectsForTeacherWeek(initSubjects(), selectedItem!!.id) as Serializable
        )
        startActivity(intent)
    }
}
package com.example.secondpartoflab1.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.secondpartoflab1.R
import com.example.secondpartoflab1.model.Subject
import com.example.secondpartoflab1.util.isLessonGoingNow
import java.time.format.DateTimeFormatter


open class CustomDataAdapter(
    val subjects: List<Subject>,
    val context: Context
) : BaseAdapter() {

    val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = subjects.size

    override fun getItem(position: Int): Any = subjects[position]

    override fun getItemId(position: Int): Long = subjects[position].id.toLong()

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val convertViewInside =
            convertView ?: layoutInflater.inflate(R.layout.subj, null)

        val teacher = convertViewInside.findViewById<TextView>(R.id.teacher)
        teacher.setText("Преподаватель: ${subjects[position].teacher.name}")
        val name = convertViewInside.findViewById<TextView>(R.id.name)
        name.setText("Предмет: ${subjects[position].name}")
        val time = convertViewInside.findViewById<TextView>(R.id.time)
        time.setText("Время начала: ${subjects[position].time.format(DateTimeFormatter.ofPattern("HH:mm, EEEE"))}")
        val classroom = convertViewInside.findViewById<TextView>(R.id.classroom)
        classroom.setText("Кабинет № ${subjects[position].classroom}")
        val building = convertViewInside.findViewById<TextView>(R.id.building)
        building.setText("Корпус № ${subjects[position].building}")
        val isGoing = convertViewInside.findViewById<TextView>(R.id.isGoing)
        val isGoingLesson = isLessonGoingNow(subjects[position].time)
        if (isGoingLesson) {
            isGoing.setText("Идет: Да")
        } else {
            isGoing.setText("Идет: Нет")
        }
        return convertViewInside
    }

}

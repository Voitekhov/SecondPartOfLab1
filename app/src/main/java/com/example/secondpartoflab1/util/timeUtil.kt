package com.example.secondpartoflab1.util

import com.example.secondpartoflab1.model.Subject
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime

fun isLessonGoingNow(dateTime: LocalDateTime): Boolean {
    val now = LocalDateTime.now()
    return (now.isAfter(dateTime) || dateTime == now) && (dateTime.isBefore(
        now.plusHours(1).plusMinutes(20)
    ) || dateTime.plusHours(1).plusMinutes(20) == now
            )
}

fun getSubjectsForStudentWeek(subjects: List<Subject>, groupId: Int): List<Subject> {
    val now = LocalDate.now()
    val monday = now.with(DayOfWeek.MONDAY)
    return subjects.filter { su ->
        su.time.toLocalDate().isAfter(monday) && su.time.toLocalDate()
            .isBefore(monday.plusDays(7)) /*&& su.group.id == groupId*/
    }.toList()
}

fun getSubjectsForTeacherWeek(subjects: List<Subject>, teacherId: Int): List<Subject> {
    val now = LocalDate.now()
    val monday = now.with(DayOfWeek.MONDAY)
    return subjects.filter { su ->
        su.time.toLocalDate().isAfter(monday) && su.time.toLocalDate()
            .isBefore(monday.plusDays(7)) && su.teacher.id == teacherId
    }.toList()
}

fun getSubjectsForStudentDay(subjects: List<Subject>, groupId: Int): List<Subject> {
    val now = LocalDateTime.now()
    return subjects.filter { su ->
        su.time.dayOfMonth == now.dayOfMonth &&
                su.time.dayOfWeek == now.dayOfWeek && su.time.month == now.month /*&& su.group.id == groupId*/
    }
}

fun getSubjectsForTeacherDay(subjects: List<Subject>, teacherId: Int): List<Subject> {
    val now = LocalDateTime.now()
    return subjects.filter { su ->
        su.time.dayOfMonth == now.dayOfMonth &&
                su.time.dayOfWeek == now.dayOfWeek && su.time.month == now.month && su.teacher.id == teacherId
    }
}

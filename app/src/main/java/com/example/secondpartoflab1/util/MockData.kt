package com.example.secondpartoflab1.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

var id = 10;
val groupNames = arrayListOf("ПИ 19-2", "Э-20-1", "Ю-19-1", "М-20-4")
val teacherName = arrayListOf("Арнольд А.Ю", "Бэндер О.В", "Кирков Н.В", "Сухин Б.Б")
val buildings = arrayListOf("1", "23 в1", "2")
val subjectName = arrayListOf(
    "Математика",
    "Интелектуальное право",
    "Управление командой",
    "Профессиональные коммуникации"
)
val classrooms = arrayListOf(1, 23, 233, 666, 777)
val datetime = arrayListOf(
    LocalDateTime.now(),
    LocalDateTime.of(2022, 1, 29, 17, 30),
    LocalDateTime.of(2022, 2, 12, 17, 30)
)
val groups = listOf(Group(1, "ПИ 19 - 2"), Group(2, "Э - 20 - 1"))
val teachers = listOf(Teacher(3, "Кирьенко П.А"), Teacher(4, "Шпильц А.Н"))
val subjects =
    listOf(
        Subject(5, groups[1], teachers[0], "ПАПС", LocalDateTime.now(), 417, "42"),
        Subject(
            6, groups[1], teachers[1], "ОБЖ", LocalDateTime.of(2022, 1, 29, 17, 30),
            222, "1"
        ),
        Subject(
            7, groups[1], teachers[1], "Предмет 1", LocalDateTime.of(2022, 2, 10, 17, 30),
            222, "1"
        ),
        Subject(
            7, groups[1], teachers[1], "Предмет 2", LocalDateTime.of(2022, 2, 13, 18, 30),
            222, "1"
        )

    )

fun initGroupList(): List<Group> {
    val groups = ArrayList<Group>()
    for (i in 0..2) {
        val index = Random.nextInt(0, groupNames.size - 1)
        groups.add(Group(++id, groupNames[index]))
        groupNames.removeAt(index)
    }
    return groups;
}

fun initTeacherList(): List<Teacher> {
    val teachers = ArrayList<Teacher>()
    for (i in 0..2) {
        val index = Random.nextInt(0, teacherName.size - 1)
        teachers.add(Teacher(++id, teacherName[index]))
        teacherName.removeAt(index)
    }
    return teachers;
}

fun initSubjects(): List<Subject> {
    return subjects;
}


fun main() {
    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm DDD"))
}

package com.example.secondpartoflab1.model

import android.os.Parcelable
import java.io.Serializable
import java.time.LocalDateTime

data class Subject (
    val id: Int, val group: Group, val teacher: Teacher, val name: String,
    val time: LocalDateTime, val classroom: Int, val building: String
): Serializable {
}
package com.example.secondpartoflab1.model

import java.io.Serializable

data class Teacher(val id: Int, val name: String) : Serializable {
    override fun toString(): String {
        return name
    }
}
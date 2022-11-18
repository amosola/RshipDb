package com.one0one.relationaldb.entities.relations

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCrossRef(
    val studentName: String,
    val subjectName: String
)
package com.one0one.relationaldb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.one0one.relationaldb.entities.School
import com.one0one.relationaldb.entities.Student

data class SchoolWithStudents (
        @Embedded val school: School,
        @Relation(
                parentColumn = "schoolName",
                entityColumn = "schoolName"
        )
        val student: List<Student>
        )
package com.one0one.relationaldb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.one0one.relationaldb.entities.Director
import com.one0one.relationaldb.entities.School
import com.one0one.relationaldb.entities.Student
import com.one0one.relationaldb.entities.Subject
import com.one0one.relationaldb.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase: RoomDatabase() {
    abstract val schoolDao: SchoolDao

    companion object{
        @Volatile
        private var INSTANCE: SchoolDatabase? = null
        fun getInstance(context: Context): SchoolDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
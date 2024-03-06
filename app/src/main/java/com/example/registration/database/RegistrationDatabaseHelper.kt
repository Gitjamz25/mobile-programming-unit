package com.example.registration.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.registration.model.RegistrationData

class RegistrationDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "registration_database"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "registration_table"
        private const val COLUMN_FIRST_NAME = "firstname"
        private const val COLUMN_LAST_NAME = "lastname"
        private const val COLUMN_GENDER = "gender"
        private const val COLUMN_DEPARTMENT = "department"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_FIRST_NAME TEXT," +
                "$COLUMN_LAST_NAME TEXT," +
                "$COLUMN_GENDER TEXT," +
                "$COLUMN_DEPARTMENT TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertRegistrationData(registrationData: RegistrationData) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(COLUMN_FIRST_NAME, registrationData.firstname)
        values.put(COLUMN_LAST_NAME, registrationData.lastname)
        values.put(COLUMN_GENDER, registrationData.gender)
        values.put(COLUMN_DEPARTMENT, registrationData.department)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }
}

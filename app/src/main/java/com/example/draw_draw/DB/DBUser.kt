package com.example.draw_draw.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.draw_draw.data.CourseModel
import com.example.draw_draw.data.UserModel

class DBUser
// creating a constructor for our database handler.
    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    // below method is for creating a database by running a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // on below line we are creating an sqlite query and we are
        // setting our column names along with their data types.
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + LOGIN_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + PHOTO_COL + " TEXT)")
        // at last we are calling a exec sql method to execute above sql query
        db.execSQL(query)
    }

    fun addNewUser(
        userName: String?,
        login: String?,
        password: String?,
        photo: String?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, userName)
        values.put(LOGIN_COL, login)
        values.put(PASSWORD_COL, password)
        values.put(PHOTO_COL, photo)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        // creating a constant variables for our database.
        private const val DB_NAME = "coursedb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "users"
        private const val ID_COL = "id"
        private const val NAME_COL = "name"
        private const val LOGIN_COL = "login"
        private const val PASSWORD_COL = "password"
        private const val PHOTO_COL = "photo"
    }

    fun readUsers(): ArrayList<UserModel>? {
        val db = this.readableDatabase
        val cursorUsers: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        val userModelArrayList: ArrayList<UserModel> = ArrayList()

        if (cursorUsers.moveToFirst()) {
            do {
                userModelArrayList.add(
                    UserModel(
                        cursorUsers.getString(1),
                        cursorUsers.getString(4),
                        cursorUsers.getString(2),
                        cursorUsers.getString(3)
                    )
                )
            } while (cursorUsers.moveToNext())
            // moving our cursor to next.
        }
        cursorUsers.close()
        return userModelArrayList
    }
}

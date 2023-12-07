package com.example.draw_draw.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.draw_draw.data.CourseModel
import com.example.draw_draw.data.TeacherModel

class DBHandler
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
                + DURATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + TRACKS_COL + " TEXT)"

                + "CREATE TABLE " + "teachers" + " ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name" + " TEXT,"
                + "description" + " TEXT,"
                + "photo" + " TEXT)"
                )
        // at last we are calling a exec sql method to execute above sql query
        db.execSQL(query)
    }
    // this method is use to add new course to our sqlite database.
    fun addNewCourse(
        courseName: String?,
        courseDuration: String?,
        courseDescription: String?,
        courseTracks: String?
    ) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        val db = this.writableDatabase
        // on below line we are creating a
        // variable for content values.
        val values = ContentValues()
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, courseName)
        values.put(DURATION_COL, courseDuration)
        values.put(DESCRIPTION_COL, courseDescription)
        values.put(TRACKS_COL, courseTracks)
        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values)
        // at last we are closing our
        // database after adding database.
        db.close()
    }

    fun addNewTeacher(
        name: String?,
        description: String?,
        photo: String?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("description", description)
        values.put("photo", photo)
        db.insert("teachers", null, values)
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "coursedb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "mycourses"
        private const val ID_COL = "id"
        private const val NAME_COL = "name"
        private const val DURATION_COL = "duration"
        private const val DESCRIPTION_COL = "description"
        private const val TRACKS_COL = "tracks"
    }

    // we have created a new method for reading all the courses.
    fun readCourses(): ArrayList<CourseModel>? {
        // on below line we are creating a database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // on below line we are creating a new array list.
        val courseModelArrayList: ArrayList<CourseModel> = ArrayList()

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModelArrayList.add(
                    CourseModel(
                        cursorCourses.getString(1),
                        cursorCourses.getString(4),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)
                    )
                )
            } while (cursorCourses.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor and returning our array list.
        cursorCourses.close()
        return courseModelArrayList
    }

    fun readTeachers(): ArrayList<TeacherModel>? {
        val db = this.readableDatabase
        val cursorTeachers: Cursor = db.rawQuery("SELECT * FROM teachers", null)
        val teacherModelArrayList: ArrayList<TeacherModel> = ArrayList()
        if (cursorTeachers.moveToFirst()) {
            do {
                teacherModelArrayList.add(
                    TeacherModel(
                        cursorTeachers.getString(1),
                        cursorTeachers.getString(3),
                        cursorTeachers.getString(2)
                    )
                )
            } while (cursorTeachers.moveToNext())
        }
        cursorTeachers.close()
        return teacherModelArrayList
    }
}

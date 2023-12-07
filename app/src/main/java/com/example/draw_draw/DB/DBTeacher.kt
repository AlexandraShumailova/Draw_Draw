//package com.example.draw_draw.DB
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import com.example.draw_draw.data.CourseModel
//import com.example.draw_draw.data.TeacherModel
//
//class DBTeacher
//// creating a constructor for our database handler.
//    (context: Context?) :
//    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
//    // below method is for creating a database by running a sqlite query
//    override fun onCreate(db: SQLiteDatabase) {
//        // on below line we are creating an sqlite query and we are
//        // setting our column names along with their data types.
//        val query = ("CREATE TABLE " + TABLE_NAME + " ("
//                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + NAME_COL + " TEXT,"
//                + DESCRIPTION_COL + " TEXT,"
//                + PHOTO_COL + " TEXT)")
//        // at last we are calling a exec sql method to execute above sql query
//        db.execSQL(query)
//    }
//
//    // this method is use to add new course to our sqlite database.
//    fun addNewTeacher(
//        name: String?,
//        description: String?,
//        photo: String?
//    ) {
//        // on below line we are creating a variable for
//        // our sqlite database and calling writable method
//        // as we are writing data in our database.
//        val db = this.writableDatabase
//        // on below line we are creating a
//        // variable for content values.
//        val values = ContentValues()
//        // on below line we are passing all values
//        // along with its key and value pair.
//        values.put(NAME_COL, name)
//        values.put(DESCRIPTION_COL, description)
//        values.put(PHOTO_COL, photo)
//        // after adding all values we are passing
//        // content values to our table.
//        db.insert(TABLE_NAME, null, values)
//        // at last we are closing our
//        // database after adding database.
//        db.close()
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        // this method is called to check if the table exists already.
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
//        onCreate(db)
//    }
//
//    companion object {
//        // creating a constant variables for our database.
//        // below variable is for our database name.
//        private const val DB_NAME = "coursedb"
//
//        // below int is our database version
//        private const val DB_VERSION = 1
//
//        // below variable is for our table name.
//        private const val TABLE_NAME = "teachers"
//
//        // below variable is for our id column.
//        private const val ID_COL = "id"
//
//        // below variable is for our course name column
//        private const val NAME_COL = "name"
//
//        // below variable for our course description column.
//        private const val DESCRIPTION_COL = "description"
//
//        // below variable is for our course tracks column.
//        private const val PHOTO_COL = "photo"
//    }
//
//    // we have created a new method for reading all the courses.
//    fun readTeachers(): ArrayList<TeacherModel>? {
//        // on below line we are creating a database for reading our database.
//        val db = this.readableDatabase
//
//        // on below line we are creating a cursor with query to read data from database.
//        val cursorTeachers: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
//
//        // on below line we are creating a new array list.
//        val teacherModelArrayList: ArrayList<TeacherModel> = ArrayList()
//
//        // moving our cursor to first position.
//        if (cursorTeachers.moveToFirst()) {
//            do {
//                // on below line we are adding the data from cursor to our array list.
//                teacherModelArrayList.add(
//                    TeacherModel(
//                        cursorTeachers.getString(1),
//                        cursorTeachers.getString(3),
//                        cursorTeachers.getString(2)
//                    )
//                )
//            } while (cursorTeachers.moveToNext())
//            // moving our cursor to next.
//        }
//        // at last closing our cursor and returning our array list.
//        cursorTeachers.close()
//        return teacherModelArrayList
//    }
//}
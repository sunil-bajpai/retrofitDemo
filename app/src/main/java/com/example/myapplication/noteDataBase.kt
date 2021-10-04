package com.example.notesapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android.db.ioThread


@Database(
    entities = [Note::class, City::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
    abstract fun getCityDao(): CityDao

    companion object {

        @Volatile
        private var INSTANCE: NoteDatabase? = null
        val PREPOPULATE_DATA = listOf(
            City(1, "Lucknow",226010),
            City(2, "Delhi",110001),
            City(3, "Bengaluru",560001),
            City(4, "Kolkata",700001),
            City(5, "Mumbai",400001),
            City(6, "Pune",411001))

        fun getInstance(context: Context): NoteDatabase {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "noteDb"
                    ).allowMainThreadQueries()
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                // insert the data on the IO Thread
                                ioThread {
                                    getInstance(context).getCityDao().addCity(PREPOPULATE_DATA)
                                }
                            }
                        })
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}

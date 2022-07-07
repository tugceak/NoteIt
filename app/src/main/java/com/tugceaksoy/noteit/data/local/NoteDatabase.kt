package com.tugceaksoy.noteit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tugceaksoy.noteit.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase :RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object{
        val DATABASE_NAME: String = "note_db"
    }

}
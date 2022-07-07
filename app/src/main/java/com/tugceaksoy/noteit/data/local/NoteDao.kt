package com.tugceaksoy.noteit.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tugceaksoy.noteit.data.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes_table")
   fun fetch(): LiveData<List<Note>>


}
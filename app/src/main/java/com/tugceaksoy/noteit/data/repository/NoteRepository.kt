package com.tugceaksoy.noteit.data.repository


import androidx.lifecycle.LiveData
import com.tugceaksoy.noteit.data.local.NoteDao
import com.tugceaksoy.noteit.data.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor( private val noteDao: NoteDao)
{

    val readAllData: LiveData<List<Note>> = noteDao.fetch()
    suspend fun addNote(note: Note){
       noteDao.insert(note)
    }


}
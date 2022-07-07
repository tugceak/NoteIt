package com.tugceaksoy.noteit.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugceaksoy.noteit.data.model.Note
import com.tugceaksoy.noteit.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RoomViewModel @Inject constructor(private val repository: NoteRepository) :ViewModel(){
    val readAllData: LiveData<List<Note>>
    init {
        readAllData=repository.readAllData
    }

    fun addNote(note: Note){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addNote(note)
        }
    }
}
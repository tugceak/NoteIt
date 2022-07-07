package com.tugceaksoy.noteit.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,

    var noteTitle: String,

    var noteInside: String,

    )


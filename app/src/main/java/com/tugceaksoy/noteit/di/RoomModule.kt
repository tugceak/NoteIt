package com.tugceaksoy.noteit.di

import android.content.Context
import androidx.room.Room
import com.tugceaksoy.noteit.data.local.NoteDao
import com.tugceaksoy.noteit.data.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideNoteDb(@ApplicationContext context: Context): NoteDatabase {
        return Room
            .databaseBuilder(
                context,
                NoteDatabase::class.java,
                NoteDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteDAO(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.noteDao()
    }
}
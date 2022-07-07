package com.tugceaksoy.noteit.di


import com.tugceaksoy.noteit.data.local.NoteDao
import com.tugceaksoy.noteit.data.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        noteDao: NoteDao

    ): NoteRepository {
        return NoteRepository(noteDao)
    }
}
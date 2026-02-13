package com.example.jimmy_polanco_ap2_p1_.di

import android.content.Context
import androidx.room.Room
import com.example.jimmy_polanco_ap2_p1_.data.local.dao.CervezaDao
import com.example.jimmy_polanco_ap2_p1_.data.local.database.AppDatabase
import com.example.jimmy_polanco_ap2_p1_.data.repository.CervezaRepositoryImpl
import com.example.jimmy_polanco_ap2_p1_.domain.repository.CervezaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCervezaDao(
        database: AppDatabase
    ): CervezaDao {
        return database.cervezaDao()
    }

    @Provides
    @Singleton
    fun provideCervezaRepository(
        dao: CervezaDao
    ): CervezaRepository {
        return CervezaRepositoryImpl(dao)
    }
}
package com.example.jimmy_polanco_ap2_p1_.di

import android.content.Context
import androidx.room.Dao
import androidx.room.RoomDatabase
import com.example.jimmy_polanco_ap2_p1_.data.local.dao.Cervezadao
import com.example.jimmy_polanco_ap2_p1_.data.local.database.appdatabase
import com.example.jimmy_polanco_ap2_p1_.data.repository.CervezaRepositoryImpl
import com.example.jimmy_polanco_ap2_p1_.domain.repository.CervezaRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): appdatabase {
        return RoomDatabaseBuilder(
            context,
            appdatabase::class.java,
            "appdatabase"
        ).Build()
    }

    @provides
    @Singleton
    fun provideCervezaDao(
        database: appdatabase
    ): Cervezadao {
        return database.Cervezadao()
    }

    @provides
    @Singleton
    fun provideCervezaRepository(
        dao: Cervezadao
    ): CervezaRepository {
        return CervezaRepositoryImpl(dao)
    }

}
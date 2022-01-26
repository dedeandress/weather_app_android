package com.dedeandres.weather.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dedeandres.weather.BuildConfig
import com.dedeandres.weather.common.room.RoomDb
import com.dedeandres.weather.common.room.dao.FavoriteCityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDb {
        return Room.databaseBuilder(context, RoomDb::class.java, BuildConfig.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE).build()
    }

    @Provides
    fun provideFavoriteCityDao(database: RoomDb): FavoriteCityDao {
        return database.favoriteCityDao()
    }
}
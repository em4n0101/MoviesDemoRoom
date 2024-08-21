package com.alexbar.moviesdemoroom.di

import android.app.Application
import androidx.room.Room
import com.alexbar.moviesdemoroom.database.MovieDatabase
import com.alexbar.moviesdemoroom.repository.MovieRepository
import com.alexbar.moviesdemoroom.repository.MovieRepositoryImpl
import com.alexbar.moviesdemoroom.utils.Constants.MOVIES_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMyDataBase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            MOVIES_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()
    }



    @Provides
    @Singleton
    fun provideLocalMovieRepository(database: MovieDatabase) : MovieRepository {
        return MovieRepositoryImpl(database.dao)
    }
}
package com.belajar.jetnewsapp.di

import android.content.Context
import androidx.room.Room
import com.belajar.jetnewsapp.data.FavDAO
import com.belajar.jetnewsapp.data.FavDatabase
import com.belajar.jetnewsapp.network.NewsAPI
import com.belajar.jetnewsapp.repositories.Repository
import com.belajar.jetnewsapp.utils.Const
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun providefavDAO(database:FavDatabase):FavDAO = database.favDAO()

    @Provides
    @Singleton
    fun provideFavDatabase(@ApplicationContext context:Context):FavDatabase {
        return Room.databaseBuilder(
            context,
            FavDatabase::class.java,
            "fav_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideOkhttp():OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(clinet:OkHttpClient):NewsAPI{
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clinet)
            .build()
            .create(NewsAPI::class.java)

    }

    @Provides
    @Singleton
    fun repostory(api: NewsAPI):Repository = Repository(api)

}
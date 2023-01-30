package com.example.acronymapp.util

import android.content.Context
import androidx.room.Room
import com.example.acronymapp.api.AcronymApi
import com.example.acronymapp.api.ApiReferences
import com.example.acronymapp.database.AcronymDao
import com.example.acronymapp.database.AcronymDatabase
import com.example.acronymapp.repository.Repository
import com.example.acronymapp.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): AcronymApi = Retrofit.Builder()
        .baseUrl(ApiReferences.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AcronymApi::class.java)

    @Provides
    @Singleton
    fun provideRepo(acronymApi: AcronymApi, acronymDao: AcronymDao): Repository = RepositoryImpl(acronymApi,acronymDao)


    @Provides
    @Singleton
    fun provideDao(database: AcronymDatabase) = database.getDao()

}
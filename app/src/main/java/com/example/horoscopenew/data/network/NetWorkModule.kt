package com.example.horoscopenew.data.network

import com.example.horoscopenew.data.RepositoryImpl
import com.example.horoscopenew.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return   Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    @Provides
    fun providesHoroscopeApiService(retrofit:Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun providesRepository(apiService: HoroscopeApiService):Repository{
        return RepositoryImpl(apiService)
    }

}
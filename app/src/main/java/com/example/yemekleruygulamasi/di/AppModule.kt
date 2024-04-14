package com.example.yemekleruygulamasi.di

import com.example.yemekleruygulamasi.data.datasource.YemeklerDataSource
import com.example.yemekleruygulamasi.data.repo.YemeklerRepository
import com.example.yemekleruygulamasi.retrofit.ApiUtils
import com.example.yemekleruygulamasi.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDataSource(ydao:YemeklerDao): YemeklerDataSource {
        return YemeklerDataSource(ydao)
    }
    @Provides
    @Singleton
    fun provideYemeklerRepository(yds: YemeklerDataSource):YemeklerRepository{
        return YemeklerRepository(yds)
    }
    @Provides
    @Singleton
    fun provideYemeklerdao():YemeklerDao{
        return ApiUtils.getYemeklerDao()
    }
}
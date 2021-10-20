package net.tc2r1.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.tc2r1.data.network.AuthApi
import net.tc2r1.data.network.RemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAuthApi(@ApplicationContext context: Context, remoteDataSource: RemoteDataSource): AuthApi {
        return remoteDataSource.buildApi(AuthApi::class.java, context)
    }
}
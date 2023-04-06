package email.aghajani.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import email.aghajani.data.remote.api.ImageApi
import email.aghajani.data.remote.datasource.image.ImageRemoteDataSource
import email.aghajani.data.remote.datasource.image.ImageRemoteDataSourceImpl
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideImageRemoteDataSource(
        imageApi: ImageApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): ImageRemoteDataSource = ImageRemoteDataSourceImpl(
        imageApi,
        ioDispatcher
    )

}
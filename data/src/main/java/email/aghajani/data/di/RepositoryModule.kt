package email.aghajani.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import email.aghajani.data.remote.datasource.image.ImageRemoteDataSource
import email.aghajani.data.repositories.ImageRepositoryImpl
import email.aghajani.domain.repositories.image.ImageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideImageRepository(
        imageRemoteDataSource: ImageRemoteDataSource
    ): ImageRepository = ImageRepositoryImpl(imageRemoteDataSource)
}
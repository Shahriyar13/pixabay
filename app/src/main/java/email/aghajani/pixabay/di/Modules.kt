package email.aghajani.pixabay.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import email.aghajani.domain.usecases.image.FetchImagesUseCase
import email.aghajani.pixabay.ui.features.posts.PostsPagingSource
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Modules {

    @Provides
    @Singleton
    fun providePostPagingSource(
        fetchImagesUseCase: FetchImagesUseCase,
    ) = PostsPagingSource(fetchImagesUseCase)
}
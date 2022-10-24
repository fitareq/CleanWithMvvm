package org.group.dird.cleanarchitecturepractice.framework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.group.dird.cleanarchitecturepractice.framework.ApiService
import org.group.dird.cleanarchitecturepractice.framework.UseCases
import org.group.dird.cleanarchitecturepractice.framework.RemotePostsDataSource
import org.group.dird.core.domain.PostRepository
import org.group.dird.core.usecases.GetPosts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Singleton
    val baseUrl = "https://jsonplaceholder.typicode.com/"

   /* @Provides
    @Singleton
    fun providesGetPost(
        postRepository: PostRepository
    ):GetPosts{
        return GetPosts(postRepository)
    }*/

    @Provides
    @Singleton
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApi(
        retrofit: Retrofit
    ):ApiService{
        return retrofit.create(ApiService::class.java)
    }
    @Provides
    @Singleton
    fun providesRemotePostDataSource(
        apiService: ApiService
    ): RemotePostsDataSource{
        return RemotePostsDataSource(apiService)
    }

    @Provides
    @Singleton
    fun providesPostRepository(
        postDataSource: RemotePostsDataSource
    ): PostRepository {
        return PostRepository(postDataSource)
    }
    @Provides
    @Singleton
    fun providesUseCases(
        postRepository: PostRepository
    ): UseCases {
        return UseCases(GetPosts(postRepository))
    }

    /*@Provides
    @Singleton
    fun providePostDataSource(
        remotePostsDataSource: RemotePostsDataSource
    ):PostDataSource{
        return remotePostsDataSource
    }*/


}
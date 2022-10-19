package org.group.dird.cleanarchitecturepractice.framework

import org.group.dird.core.data.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getAllPost():List<Post>
}
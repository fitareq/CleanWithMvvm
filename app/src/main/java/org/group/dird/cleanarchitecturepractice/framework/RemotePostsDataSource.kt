package org.group.dird.cleanarchitecturepractice.framework

import org.group.dird.core.data.Post
import org.group.dird.core.domain.PostDataSource
import javax.inject.Inject


class RemotePostsDataSource @Inject constructor(
    private val api: ApiService
) :PostDataSource{
    override suspend fun getPosts(): List<Post> {
        return api.getAllPost()
    }
}


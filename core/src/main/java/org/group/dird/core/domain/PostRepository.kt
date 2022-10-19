package org.group.dird.core.domain

import org.group.dird.core.data.Post

class PostRepository(
    private val postDataSource: PostDataSource
) {
    suspend fun getPosts(): List<Post> {
        return postDataSource.getPosts()
    }
}
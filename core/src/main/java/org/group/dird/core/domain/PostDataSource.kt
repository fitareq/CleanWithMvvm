package org.group.dird.core.domain

import org.group.dird.core.data.Post

interface PostDataSource {
    suspend fun getPosts():List<Post>
}
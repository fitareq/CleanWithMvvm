package org.group.dird.core.usecases

import org.group.dird.core.data.Post
import org.group.dird.core.domain.PostRepository

class GetPosts(
    private val postsRepository: PostRepository
) {
    suspend operator fun invoke(): List<Post> {
        return postsRepository.getPosts()
    }
}
package org.group.dird.cleanarchitecturepractice.framework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CleanApplication():Application() {
    override fun onCreate() {
        super.onCreate()

      /*  val postRepository: PostRepository = PostRepository(remotePostsDataSource)

        mViewModelFactory.inject(
            this,
            Interactor(GetPosts(postRepository))
        )*/
    }
}
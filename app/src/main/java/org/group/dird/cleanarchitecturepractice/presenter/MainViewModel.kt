package org.group.dird.cleanarchitecturepractice.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.group.dird.cleanarchitecturepractice.framework.UseCases
import org.group.dird.core.data.Post
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
) :ViewModel(){

    private var _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts
    fun getPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(useCases.getPosts())
        }
    }
}
package com.example.requisicoeretrofit.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.requisicoeretrofit.data.RetrofitInstance
import com.example.requisicoeretrofit.data.models.CreatePostRequest
import com.example.requisicoeretrofit.data.models.Post
import com.example.requisicoeretrofit.data.models.User
import com.example.requisicoeretrofit.data.models.UserCreateRequest
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    var post: List<Post> by mutableStateOf(listOf())
    var users: List<User> by mutableStateOf(listOf())
    private val userId = 1

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                users = RetrofitInstance.api.getUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun fetchPosts() {
        try {
            post = RetrofitInstance.api.getPosts(userId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun createUser(
        name: String,
        email: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                val newUser = UserCreateRequest(name, email)
                RetrofitInstance.api.createUser(newUser)
                fetchUsers()
                onSuccess()
            } catch (e: Exception) {
                e.printStackTrace()
                onError()
            }
        }
    }

    fun createPost(
        title: String,
        content: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                val newPost = UserCreateRequest(title, content)
                RetrofitInstance.api.createUser(newPost)
                fetchPosts()
                onSuccess()
            } catch (e: Exception) {
                e.printStackTrace()
                onError()
            }
        }
    }

    fun deletePost(postId: Int) {
        viewModelScope.launch {
            try {
                RetrofitInstance.api.deletePost(postId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updatePost(
        postId: Int,
        title: String,
        content: String
    ) {
        viewModelScope.launch {
            try {
                val updatePost = CreatePostRequest(title, content)
                RetrofitInstance.api.updatePost(postId, updatePost)
                fetchPosts()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}
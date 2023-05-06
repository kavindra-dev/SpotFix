package com.kavi.spotfix.data.sealed

import com.kavi.spotfix.data.model.VideoL

sealed class DataState {
    class Success(val data : MutableList<VideoL>) : DataState()
    class Failure(val message : String) : DataState()
    object Loading : DataState()
    object Empty : DataState()
}

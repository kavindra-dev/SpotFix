package com.kavi.spotfix.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.kavi.spotfix.data.model.VideoL
import com.kavi.spotfix.data.sealed.DataState
import com.kavi.spotfix.util.Constants

class HomeViewModel : ViewModel(){

    val response : MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchVideoData()
    }

    private fun fetchVideoData() {
        val tlist = mutableListOf<VideoL>()
        response.value = DataState.Loading
        Constants.urlpath
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(dsnap in snapshot.children){
                        val videoItm = dsnap.getValue(VideoL::class.java)
                        if (videoItm != null)
                            tlist.add(videoItm)
                        response.value = DataState.Success(tlist)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failure(error.message)
                }

            })
    }
}
package com.kavi.spotfix.util

import com.google.firebase.database.FirebaseDatabase

class Constants {

    // Constant section store firebase instance and api path
    companion object{
        val firebaseInst = FirebaseDatabase.getInstance()
        val urlpath = firebaseInst.getReference("Video")
    }
}
package com.example.notesapp.ui

import android.content.Context
import android.widget.Toast

//showing Toast message
fun Context.toast(message:String)= Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

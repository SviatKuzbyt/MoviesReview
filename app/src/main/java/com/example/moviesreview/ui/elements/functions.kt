package com.example.moviesreview.ui.elements

import android.content.Context
import android.widget.Toast

fun makeToastError(message: String, context: Context?){
    Toast.makeText(
        context,
        "Error: $message",
        Toast.LENGTH_LONG
    ).show()
}
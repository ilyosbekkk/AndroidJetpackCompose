package com.example.androidjetpackcompose.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.androidjetpackcompose.R


const val  DEFAULT_IMAGE_URL = R.drawable.empty_image

@Composable
fun loadPicture(url: String, @DrawableRes defaultImage: Int): MutableState<Bitmap?> {
    val bitmapSate: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapSate.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                Log.e(TAG, "onLoadCleared: ${placeholder.toString()}", )

            }
        })
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapSate.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                Log.e(TAG, "onLoadCleared: ${placeholder.toString()}", )
            }
        })

    return bitmapSate
}
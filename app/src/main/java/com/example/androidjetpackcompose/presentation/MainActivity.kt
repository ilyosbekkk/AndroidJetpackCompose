package com.example.androidjetpackcompose.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidjetpackcompose.BaseApplication
import com.example.androidjetpackcompose.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var app: BaseApplication

    @Inject
    lateinit var randomString: String
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(TAG, "onCreate: " + randomString)
        Log.e(TAG, "onCreate: " + app)

    }
}

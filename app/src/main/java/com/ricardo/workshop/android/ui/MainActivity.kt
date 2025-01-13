package com.ricardo.workshop.android.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.ricardo.workshop.android.data.LocalDataSource

internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToastListScreen(toasts = LocalDataSource().getToasts())
        }
    }
}
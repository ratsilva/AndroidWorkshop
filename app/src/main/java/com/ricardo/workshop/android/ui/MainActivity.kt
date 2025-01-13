package com.ricardo.workshop.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ricardo.workshop.android.R

internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // attach fragment to activity
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ToastListFragment.newInstance())
            .commitNow()
    }
}
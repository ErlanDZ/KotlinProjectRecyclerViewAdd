package com.example.kotlinprojectrecyclerviewadd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinprojectrecyclerviewadd.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, MainFragment())
            .commit()
    }
}
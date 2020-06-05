package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createProfile?.setOnClickListener { _ ->
            val intent = Intent(applicationContext, CreateProfile::class.java)
            startActivity(intent)
        }

        showProfiles?.setOnClickListener { _ ->
            val intent = Intent(applicationContext, ListProfiles::class.java)
            startActivity(intent)
        }

        if(ApplicationVariables.getProfile() != null)
        {
            currentProfileInfo.text = ApplicationVariables.getProfile()?.firstName + " " + ApplicationVariables.getProfile()?.lastName
        }

    }

}

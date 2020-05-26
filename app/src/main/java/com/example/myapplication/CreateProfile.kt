package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.model.Profile
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_create_profile.*

class CreateProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Create Profile"
        setContentView(R.layout.activity_create_profile)

        button?.setOnClickListener { view ->
            var profile = Profile()
            profile.firstName = firstName.text.toString()
            profile.lastName = lastName.text.toString()
            profile.address1 = address1.text.toString()
            profile.address2 = address2.text.toString()
            profile.state = state.text.toString()
            profile.zipCode = Integer.parseInt(zipCode.text.toString())
            profile.email = email.toString()
            profile.phoneNumber = phoneNumber.toString()
            profile.libraryCardNumber = Integer.parseInt(libraryCardNumber.text.toString())
            profile.pickUpLocation = ""//pickUpLocation.selectedItem.toString()""
            profile.howToContact = ""//howToContact.selectedItem.toString()

            applicationContext.openFileOutput("profile_ " + profile.firstName, Context.MODE_PRIVATE).use {
                it?.write(Gson().toJson(profile).toByteArray())
            }

            Snackbar.make(view, "Profile Saved", Snackbar.LENGTH_LONG).show()
        }
    }
}

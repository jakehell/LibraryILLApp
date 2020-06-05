package com.example.myapplication

import com.example.myapplication.model.Profile

class ApplicationVariables
{
    var profile: Profile? = null
    companion object {
        private val instance = ApplicationVariables()

        fun setProfile(profile: Profile?)
        {
            instance.profile = profile
        }

        fun getProfile() : Profile?
        {
            return instance.profile
        }
    }
}
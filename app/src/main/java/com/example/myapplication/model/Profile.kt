package com.example.myapplication.model

import java.lang.StringBuilder

class Profile {
    var firstName: String = ""
    var lastName: String = ""
    var address1: String = ""
    var address2: String = ""
    var state: String = ""
    var zipCode: Int = 0
    var email: String = ""
    var phoneNumber: String = ""
    var libraryCardNumber: Int = 0
    var pickUpLocation: String = ""
    var howToContact: String = ""

    override fun toString(): String {
        val builder = StringBuilder()

        builder.appendln("firstName: $firstName")
        builder.appendln("lastName: $lastName")
        builder.appendln("address1: $address1")
        builder.appendln("address2: $address2")
        builder.appendln("state: $state")
        builder.appendln("zipCode: $zipCode")
        builder.appendln("email: $email")
        builder.appendln("phoneNumber: $phoneNumber")
        builder.appendln("libraryCardNumber: $libraryCardNumber")
        builder.appendln("pickUpLocation: $pickUpLocation")
        builder.appendln("howToContact: $howToContact")

        return builder.toString()
    }
}
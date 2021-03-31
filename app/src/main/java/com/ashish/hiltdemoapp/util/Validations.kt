package com.ashish.hiltdemoapp.util

import android.content.Context
import android.util.Patterns
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil

class Validations {
    //String validations
    fun String?.valid(): Boolean =
        this != null && !this.equals("null", true)
                && this.trim().isNotEmpty()

//    if(data.valid())
    
    //Email Validation
    fun String.isValidEmail(): Boolean =
        this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    //Phone number format
    fun String.formatPhoneNumber(context: Context, region: String): String? {
        val phoneNumberKit = PhoneNumberUtil.createInstance(context)
        val number = phoneNumberKit.parse(this, region)
        if (!phoneNumberKit.isValidNumber(number))
            return null
        return phoneNumberKit.format(number, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
    }
}
package com.nero.saveoassignment.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Country(
    val code: String,
    val name: String,
    val timezone: String
) : Parcelable
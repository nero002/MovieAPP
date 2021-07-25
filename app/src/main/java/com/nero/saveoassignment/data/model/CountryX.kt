package com.nero.saveoassignment.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryX(
    val code: String,
    val name: String,
    val timezone: String
) : Parcelable
package com.nero.saveoassignment.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class WebChannel(
    val country: CountryX,
    val id: Int,
    val name: String
):Parcelable
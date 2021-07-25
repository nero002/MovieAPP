package com.nero.saveoassignment.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Links(
    val previousepisode: Previousepisode,
    val self: Self
):Parcelable
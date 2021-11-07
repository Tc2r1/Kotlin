package com.nudennie.marsrealestate.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarsProperty
    (
    @Json(name = "price")
    val price: Double,

    @Json(name = "id")
    val id: String,

    @Json(name = "type")
    val type: String,

    @Json(name = "img_src")
    val imgSrcUrl: String

) : Parcelable {
    val isRental
        get() = type == "rent"
}
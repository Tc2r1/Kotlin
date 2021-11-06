package com.nudennie.marsrealestate.network

import com.squareup.moshi.Json

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
)
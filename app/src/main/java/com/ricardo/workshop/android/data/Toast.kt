package com.ricardo.workshop.android.data

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

internal data class Toast(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val currency: String,
    @SerializedName("last_sold")
    val lastSold: String
)

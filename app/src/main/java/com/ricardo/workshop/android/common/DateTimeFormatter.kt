package com.ricardo.workshop.android.common

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

internal object DateTimeFormatter {

    fun format(dateString: String): String {
        val inputFormatter = DateTimeFormatter.ISO_INSTANT
        val instant = Instant.from(inputFormatter.parse(dateString))
        val outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a")
        return outputFormatter.format(instant.atZone(ZoneId.systemDefault()))
    }
}
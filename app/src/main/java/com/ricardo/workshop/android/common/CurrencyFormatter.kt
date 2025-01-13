package com.ricardo.workshop.android.common

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Currency

internal object CurrencyFormatter {

    fun format(currencyCode: String, amount: BigDecimal): String {
        val currency = Currency.getInstance(currencyCode)
        val format: NumberFormat = NumberFormat.getCurrencyInstance().apply {
            setCurrency(currency)
        }
        return format.format(amount)
    }
}
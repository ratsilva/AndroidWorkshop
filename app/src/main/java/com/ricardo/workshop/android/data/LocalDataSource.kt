package com.ricardo.workshop.android.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

internal class LocalDataSource {

    private val localStorage = """
[{
    "name": "Avocado Toast",
    "price": "5.99",
    "id": 1,
    "currency": "EUR",
    "last_sold": "2020-11-28T15:14:22Z"
  },
  {
    "name": "Bacon Toast",
    "id": 2,
    "price": "1.99",
    "currency": "EUR",
    "last_sold": "2021-01-30T02:24:04Z"
  },
  {
    "name": "Crunchy Toast",
    "id": 3,
    "price": "0.99",
    "currency": "BRL",
    "last_sold": "2021-03-17T03:45:47Z"
  }
]
"""

    fun getToasts(): List<Toast> {
        // read toast list from file
        val listToastType = object : TypeToken<List<Toast>>() {}.type
        val toasts: List<Toast> = Gson().fromJson(localStorage, listToastType)
        return toasts
    }

}
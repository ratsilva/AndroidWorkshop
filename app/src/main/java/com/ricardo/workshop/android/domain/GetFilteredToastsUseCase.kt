package com.ricardo.workshop.android.domain

import com.ricardo.workshop.android.data.ApiServiceFactory
import com.ricardo.workshop.android.data.Toast

internal class GetFilteredToastsUseCase {

    private val apiService = ApiServiceFactory.createApiService()

    suspend operator fun invoke(searchTerm: String): List<Toast> {
        val toasts = apiService.getToasts()

        if (searchTerm.isEmpty()) {
            return toasts
        }

        val filteredToasts = toasts.filter { it.name.contains(searchTerm, ignoreCase = true) }
        return filteredToasts
    }

}
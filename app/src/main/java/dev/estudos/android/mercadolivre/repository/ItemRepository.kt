package dev.estudos.android.mercadolivre.repository

import dev.estudos.android.mercadolivre.model.SearchResponse
import retrofit2.Call

interface ItemRepository {

    suspend fun search(query: String): SearchResponse

}
package dev.estudos.android.mercadolivre.repository

import dev.estudos.android.mercadolivre.model.SearchResponse
import retrofit2.Call

interface ItemRepository {

    fun search(query: String): Call<SearchResponse>

}
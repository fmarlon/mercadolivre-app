package dev.estudos.android.mercadolivre.webclient

import dev.estudos.android.mercadolivre.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemSearchService {

    @GET("/sites/MLB/search")
    suspend fun search(@Query("q") query: String): SearchResponse

}
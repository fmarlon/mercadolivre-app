package dev.estudos.android.mercadolivre.repository

import dev.estudos.android.mercadolivre.model.SearchResponse
import dev.estudos.android.mercadolivre.webclient.ItemSearchService
import retrofit2.Call

class ItemRepositoryImpl(val itemSearchService: ItemSearchService): ItemRepository {

    override fun search(query: String): Call<SearchResponse> {
        return itemSearchService.search(query)
    }

}
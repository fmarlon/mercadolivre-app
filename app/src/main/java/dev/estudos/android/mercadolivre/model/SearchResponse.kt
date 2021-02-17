package dev.estudos.android.mercadolivre.model

data class SearchResponse(
    val query: String,
    val paging: Paging,
    val results: List<Item>
)

data class Paging(
    val total: Int,
    val offset: Int,
    val limit: Int
)
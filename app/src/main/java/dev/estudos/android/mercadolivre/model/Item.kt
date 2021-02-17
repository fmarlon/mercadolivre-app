package dev.estudos.android.mercadolivre.model

data class Item(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: Double,
    val installments: Installments,
    val shipping: Shipping
)

data class Installments (
    val quantity: Int,
    val amount: Double,
    val rate: Double
)

data class Shipping (
    val freeShipping: Boolean,
    val logisticType: String
)
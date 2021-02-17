package dev.estudos.android.mercadolivre.config

import dev.estudos.android.mercadolivre.repository.ItemRepository
import dev.estudos.android.mercadolivre.repository.ItemRepositoryImpl
import dev.estudos.android.mercadolivre.ui.ListaItensViewModel
import dev.estudos.android.mercadolivre.webclient.ItemSearchService
import dev.estudos.android.mercadolivre.webclient.WebClientFactory
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BASE_URL = "https://api.mercadolibre.com/"

val appModule = module {

    single<ItemSearchService> { WebClientFactory.getRetrofitInstance(BASE_URL).create(ItemSearchService::class.java) }

    single<ItemRepository> { ItemRepositoryImpl(get()) }

    viewModel { ListaItensViewModel(get()) }
}
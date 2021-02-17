package dev.estudos.android.mercadolivre.webclient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebClientFactory {

    companion object {

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance(baseURL : String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}
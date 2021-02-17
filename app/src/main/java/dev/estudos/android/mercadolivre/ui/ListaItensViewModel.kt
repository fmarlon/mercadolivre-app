package dev.estudos.android.mercadolivre.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.estudos.android.mercadolivre.model.Item
import dev.estudos.android.mercadolivre.model.SearchResponse
import dev.estudos.android.mercadolivre.repository.ItemRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaItensViewModel(val itemRepository: ItemRepository): ViewModel() {

    private val _listItems = MutableLiveData<SearchResponse>()
    val listItems : LiveData<SearchResponse> = _listItems

    fun search(query: String) {
        itemRepository.search(query).enqueue(object : Callback<SearchResponse> {

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.e("ListaItensViewModel.search", t.toString())
                // _listItems.value = SearchResponse(query, results = listOf(Item(title = "ERROR")))
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                _listItems.value = response.body()
            }

        })
    }

}
package dev.estudos.android.mercadolivre.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.estudos.android.mercadolivre.model.Item
import dev.estudos.android.mercadolivre.model.SearchResponse
import dev.estudos.android.mercadolivre.repository.ItemRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaItensViewModel(val itemRepository: ItemRepository): ViewModel() {

    private val _listItems = MutableLiveData<SearchResponse>()
    val listItems : LiveData<SearchResponse> = _listItems

    fun search(query: String) {
        viewModelScope.launch {
            Log.d("AndroidLabs", "Buscando itens com courotines iniciado")

            val response = itemRepository.search(query)
            _listItems.value = response

            Log.d("AndroidLabs", "Buscando itens com courotines finalizado")
        }
    }

}
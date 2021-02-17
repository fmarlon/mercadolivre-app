package dev.estudos.android.mercadolivre.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.estudos.android.mercadolivre.R
import dev.estudos.android.mercadolivre.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel : ListaItensViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Notebooks no Mercado Livre"

        viewModel.search("Notebook")

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.listview.layoutManager = layoutManager

        val listAdapter = ItemRecycleViewAdapter(listOf())
        binding.listview.adapter = listAdapter

        viewModel.listItems.observe(this, Observer {
            listAdapter.items = it.results
            listAdapter.notifyDataSetChanged()
        })

    }

}
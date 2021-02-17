package dev.estudos.android.mercadolivre.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.estudos.android.mercadolivre.databinding.ItemProdutoBinding
import dev.estudos.android.mercadolivre.model.Item
import java.text.DecimalFormat

class ItemRecycleViewAdapter(var items: List<Item>): RecyclerView.Adapter<ItemRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = ViewHolder(
            ItemProdutoBinding.inflate(layoutInflater, parent, false)
        )
        return viewHolder;
    }

    override fun getItemCount() =  items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val binding: ItemProdutoBinding) : RecyclerView.ViewHolder(binding.root) {

        var item: Item? = null

        fun bind(item: Item) {
            this.item = item

            Glide.with(this.itemView.context).load(item.thumbnail).into(binding.imgProduto);
            binding.txtTitulo.text = item.title
            binding.txtPreco.text = DecimalFormat.getCurrencyInstance().format(item.price)
            binding.txtFrete.text = if (item.shipping.freeShipping) "Frete Grátis" else ""
        }

    }

}
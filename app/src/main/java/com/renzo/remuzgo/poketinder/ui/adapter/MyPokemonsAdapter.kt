package com.renzo.remuzgo.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.renzo.remuzgo.poketinder.data.database.entities.MyPokemonEntity
import com.renzo.remuzgo.poketinder.databinding.ItemPokemonSavedBinding
import com.renzo.remuzgo.poketinder.ui.holder.MyPokemonsHolder

class MyPokemonsAdapter(val list: List<MyPokemonEntity>):
    RecyclerView.Adapter<MyPokemonsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = ItemPokemonSavedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPokemonsHolder(view.root)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size


}
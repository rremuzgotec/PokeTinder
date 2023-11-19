package com.renzo.remuzgo.poketinder.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.renzo.remuzgo.poketinder.data.database.entities.MyPokemonEntity
import com.renzo.remuzgo.poketinder.databinding.FragmentFavoriteBinding
import com.renzo.remuzgo.poketinder.ui.adapter.MyPokemonsAdapter
import com.renzo.remuzgo.poketinder.ui.viewmodel.FavoriteViewModel

class FavoriteFragment : BaseFragment
<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private var listMyPokemon = mutableListOf<MyPokemonEntity>()

    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel.getMyPokemons(requireContext())

        binding.rvPokemons.adapter = adapter

        favoriteViewModel.myPokemonList.observe(this) {
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener {
            favoriteViewModel.deleteAllPokemon(requireContext())
        }
    }


}
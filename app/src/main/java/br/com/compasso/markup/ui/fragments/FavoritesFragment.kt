package br.com.compasso.markup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compasso.markup.databinding.FragmentFavoritesBinding
import br.com.compasso.markup.ui.adapters.FavoriteEventAdapter
import br.com.compasso.markup.ui.viewmodels.EventsViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritesFragment : BaseFragment() {
    private val binding by lazy { FragmentFavoritesBinding.inflate(layoutInflater) }
    private val favoriteAdapter by inject<FavoriteEventAdapter>()
    private val eventsViewModel by viewModel<EventsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.favorites.adapter = favoriteAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFavorites()
    }

    private fun loadFavorites() {
        eventsViewModel.favorites().observe(viewLifecycleOwner, { events ->
            favoriteAdapter.addAll(events)
        })
    }
}
package br.com.compasso.findit.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compasso.findit.data.models.Event
import br.com.compasso.findit.databinding.FragmentEventsBinding
import br.com.compasso.findit.http.repositories.Resource
import br.com.compasso.findit.http.repositories.Resource.Status.*
import br.com.compasso.findit.services.extensions.toast
import br.com.compasso.findit.ui.adapters.EventAdapter
import br.com.compasso.findit.ui.viewmodels.EventsViewModel
import com.ethanhua.skeleton.Skeleton
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class EventsFragment : BaseFragment() {
    private val eventsViewModel by viewModel<EventsViewModel>()
    private val binding by lazy { FragmentEventsBinding.inflate(layoutInflater) }
    private val eventAdapter by inject<EventAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.events.adapter = eventAdapter
        binding.swipe.setOnRefreshListener(this::load)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load()
    }

    private fun load() {
        eventsViewModel.load().observe(viewLifecycleOwner, { res ->
            res.data?.also { eventAdapter.update(it) }
            res.message?.also { toast(it) }
            when (res.status) {
                SUCCESS -> binding.swipe.isRefreshing = false
                FAILURE -> binding.swipe.isRefreshing = false
                LOADING -> binding.swipe.isRefreshing = true
            }
        })
    }
}
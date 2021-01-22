package br.com.compasso.markup.ui.fragments

import android.os.Bundle
import android.view.*
import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.databinding.FragmentEventsBinding
import br.com.compasso.markup.http.repositories.Resource.Status.*
import br.com.compasso.markup.services.extensions.toast
import br.com.compasso.markup.ui.adapters.EventAdapter
import br.com.compasso.markup.ui.viewmodels.EventsViewModel
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
        eventAdapter.onItemClick = this::details
        eventAdapter.onLike = this::like
        binding.events.adapter = eventAdapter
        binding.swipe.setOnRefreshListener(this::load)
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verifyAuthentication()
    }

    private fun like(event: Event) {
        eventsViewModel.like(event).observe(this, { res ->
            res.message?.also { toast(it) }
        })
    }

    private fun verifyAuthentication() {
        eventsViewModel.isAuthenticated().observe(this, { isAuthenticated ->
            if (!isAuthenticated) {
                controller.navigate(EventsFragmentDirections.toLogin())
                return@observe
            }
            load()
        })
    }


    private fun details(event: Event) {
        controller.navigate(EventsFragmentDirections.toEvent(event))
    }

    private fun load() {
        eventsViewModel.load().observe(this, { res ->
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
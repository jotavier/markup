package br.com.compasso.markup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compasso.markup.databinding.FragmentEventDetailsBinding
import br.com.compasso.markup.ui.viewmodels.EventViewModel
import org.koin.android.ext.android.inject

class EventDetailsFragment : BaseFragment() {
    private val binding by lazy { FragmentEventDetailsBinding.inflate(layoutInflater) }
    private val eventDetailsViewModel by inject<EventViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventDetailsViewModel.event.observe(viewLifecycleOwner, { event ->
            event?.also { binding.event = event }
        })
    }
}
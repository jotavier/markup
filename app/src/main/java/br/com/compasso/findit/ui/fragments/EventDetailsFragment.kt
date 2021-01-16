package br.com.compasso.findit.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compasso.findit.databinding.FragmentEventDetailsBinding

class EventDetailsFragment : BaseFragment() {
    private val binding by lazy { FragmentEventDetailsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}
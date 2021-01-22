package br.com.compasso.markup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compasso.markup.R
import br.com.compasso.markup.databinding.FragmentEventLocationBinding
import br.com.compasso.markup.ui.viewmodels.EventViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.android.viewmodel.ext.android.sharedViewModel

class LocationFragment : BaseFragment(), OnMapReadyCallback {
    private val binding by lazy { FragmentEventLocationBinding.inflate(layoutInflater) }
    private val eventDetailsViewModel by sharedViewModel<EventViewModel>()
    private val map by lazy { childFragmentManager.findFragmentByTag(getString(R.string.map_fragment_tag)) as SupportMapFragment }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        map.getMapAsync(this@LocationFragment)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        eventDetailsViewModel.event.observe(viewLifecycleOwner, { event ->
            event?.let {
                binding.event = event
                val eventLocation = LatLng(event.latitude, event.longitude)
                googleMap?.addMarker(MarkerOptions().position(eventLocation).title(event.title))
                googleMap?.moveCamera(CameraUpdateFactory.newLatLng(eventLocation))
                googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(eventLocation, 16f))
            }
        })
    }
}
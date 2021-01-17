package br.com.compasso.findit.data.interfaces

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compasso.findit.services.providers.StateProvider

interface IEmptyStateProviderAdapter<T : RecyclerView.ViewHolder> {

    fun onCreateHolder(parent: ViewGroup, viewType: Int): T

    fun onBindHolder(holder: T, position: Int)

    fun provider(): StateProvider
}
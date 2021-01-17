package br.com.compasso.findit.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compasso.findit.data.interfaces.IEmptyStateProviderAdapter
import br.com.compasso.findit.databinding.EmptyStateViewBinding
import br.com.compasso.findit.services.providers.StateProvider
import java.util.*

abstract class EmptyStateProviderAdapter<T : RecyclerView.ViewHolder>(
    private val list: ArrayList<*>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), IEmptyStateProviderAdapter<T> {

    private companion object {
        const val NO_SIZE = -1
        const val NOT_EMPTY = 1
        const val EMPTY = 0
        const val SINGLE_ITEM = 1
    }


    final override fun getItemCount(): Int {
        if (list.size == EMPTY) {
            return SINGLE_ITEM
        }
        return list.size
    }

    final override fun getItemViewType(position: Int): Int {
        if (list.size == EMPTY) {
            return NO_SIZE
        }
        return NOT_EMPTY
    }

    final override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == NO_SIZE) {
            return EmptyStateProviderViewHolder(
                EmptyStateViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
        return onCreateHolder(parent, viewType)
    }

    @Suppress("UNCHECKED_CAST")
    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EmptyStateProviderViewHolder -> holder.bind(provider())
            else -> onBindHolder(holder as T, position)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    protected class EmptyStateProviderViewHolder(
        private val binding: EmptyStateViewBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(provider: StateProvider) {
            binding.provider = provider
        }
    }
}

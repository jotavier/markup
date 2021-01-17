package br.com.compasso.findit.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.compasso.findit.R
import br.com.compasso.findit.data.models.Event
import br.com.compasso.findit.databinding.AdapterEventBinding
import br.com.compasso.findit.services.providers.StateProvider
import br.com.compasso.findit.ui.fragments.EventsFragment
import br.com.compasso.findit.ui.fragments.EventsFragmentDirections

class EventAdapter(private val events: ArrayList<Event>) :
    EmptyStateProviderAdapter<EventAdapter.EventViewHolder>(events) {


    override fun onCreateHolder(parent: ViewGroup, viewType: Int): EventViewHolder =
        EventViewHolder(
            AdapterEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun provider() = StateProvider(
        title = "Nenhum evento encontrado",
        message = "Oops... Não encontramos nenhum evento.\nArraste para baixo para buscar novamente",
        icon = R.drawable.ic_festival
    )

    fun update(events: List<Event>) {
        clear()
        this.events.addAll(events)
        notifyDataSetChanged()
    }

    private fun clear() {
        events.clear()
        notifyItemRangeRemoved(0, itemCount)
    }

    class EventViewHolder(private val binding: AdapterEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.event = event
            itemView.setOnClickListener {
                val controller = it.findNavController()
                controller.navigate(EventsFragmentDirections.toDetails(event))
            }
        }
    }
}

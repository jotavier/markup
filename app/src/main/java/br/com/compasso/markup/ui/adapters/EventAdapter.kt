package br.com.compasso.markup.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.compasso.markup.R
import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.databinding.AdapterEventBinding
import br.com.compasso.markup.services.providers.StateProvider

open class EventAdapter(
    private val events: ArrayList<Event>,
    var onItemClick: (event: Event) -> Unit = {},
    var onLike: (event: Event) -> Unit = {}
) :
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

    inner class EventViewHolder(private val binding: AdapterEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.event = event
            binding.container.setOnClickListener { onItemClick(event) }
            binding.favorite.setOnClickListener {
                event.favorite = !event.favorite
                onLike(event)
            }
        }
    }
}

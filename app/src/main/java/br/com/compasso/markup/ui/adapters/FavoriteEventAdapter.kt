package br.com.compasso.markup.ui.adapters

import br.com.compasso.markup.R
import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.services.providers.StateProvider

class FavoriteEventAdapter(
    private val favorites: ArrayList<Event>
) : EventAdapter(favorites) {

    override fun provider() = StateProvider(
        title = "Você ainda não curtiu nenhum evento",
        message = "Clique no ícone de coração na tela de eventos para ver os seus eventos aqui.",
        icon = R.drawable.ic_heart
    )

    fun addAll(events: List<Event>) {
        favorites.addAll(events)
        notifyDataSetChanged()
    }
}
package br.com.compasso.markup.ui.viewmodels

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.http.repositories.UserRepository

class EventViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private var _event = MutableLiveData<Event?>().also {
        it.value = mEvent
    }

    var mEvent: Event? = null
        set(value) {
            field = value
            _event.value = value
        }

    val event: LiveData<Event?> get() = _event

    fun checkIn() = mEvent?.id?.let { userRepository.execute(it) }

    fun share(context: Context) {
        val share = Intent()
        share.apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                "Venha para ${mEvent?.title}\n" +
                        "Data: ${mEvent?.datePattern()} as ${mEvent?.schedulePattern()}\n" +
                        "Local: ${
                            mEvent?.address(context)
                        }"
            )
            type = "text/plain"
        }
        context.startActivity(Intent.createChooser(share, null))
    }

    override fun onCleared() {
        super.onCleared()
        mEvent = null
    }
}

package br.com.compasso.markup.http.repositories

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.compasso.markup.data.models.CheckIn
import br.com.compasso.markup.data.models.User
import br.com.compasso.markup.http.clients.UserWebClient
import com.google.gson.Gson

class UserRepository(
    private val preferences: SharedPreferences,
    private val userWebClient: UserWebClient
) {
    private companion object {
        const val USER = "user"
        const val SUCCESS_MESSAGE = "Check-in efetuado"
    }

    fun save(user: User) {
        preferences.edit {
            putString(USER, Gson().toJson(user))
        }
    }

    fun load() = try {
        Gson().fromJson(preferences.getString(USER, null), User::class.java)
    } catch (ex: Exception) {
        null
    }

    fun execute(eventId: Long): LiveData<Resource<Int?>> {
        val checkInResult = MutableLiveData<Resource<Int?>>(Resource.loading())
        val user = load()
        userWebClient.execute(
            CheckIn(user, eventId),
            onSuccess = { code ->
                checkInResult.value = Resource.success(code, SUCCESS_MESSAGE)
            },
            onError = { message ->
                checkInResult.value = Resource.failure(message)
            })
        return checkInResult
    }
}
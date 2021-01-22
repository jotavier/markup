package br.com.compasso.markup.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.compasso.markup.data.forms.UserForm
import br.com.compasso.markup.http.repositories.UserRepository

class UserViewModel(
    val userForm: UserForm,
    private val userRepository: UserRepository
) : ViewModel() {

    fun submit(): LiveData<Boolean> {
        val isValid = userForm.isValid()
        if (isValid) {
            userRepository.save(userForm.toData())
        }
        return MutableLiveData(isValid)
    }

    fun loadAccount() {
        userRepository.load()?.also {
            userForm.email.value = it.email
            userForm.name.value = it.name
        }
    }
}

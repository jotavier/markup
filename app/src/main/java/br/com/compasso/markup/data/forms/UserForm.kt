package br.com.compasso.markup.data.forms

import androidx.lifecycle.MutableLiveData
import br.com.compasso.markup.data.interfaces.IForm
import br.com.compasso.markup.data.models.User
import br.com.compasso.markup.services.extensions.isValidEmail

data class UserForm(
    val name: MutableLiveData<String> = MutableLiveData<String>(),
    val email: MutableLiveData<String> = MutableLiveData<String>(),
    val nameError: MutableLiveData<String> = MutableLiveData<String>(""),
    val emailError: MutableLiveData<String> = MutableLiveData<String>("")
) : IForm<User> {

    companion object {
        const val EMPTY_EMAIL = "O campo e-mail é obrigatório"
        const val EMPTY_NAME = "O campo nome é obrigatório"
        const val INVALID_EMAIL = "E-mail inválido"
    }

    override fun isValid(): Boolean {
        val name = name.value
        val email = email.value

        if (name.isNullOrEmpty()) {
            nameError.value = EMPTY_NAME
            return false
        }

        if (email.isNullOrEmpty()) {
            emailError.value = EMPTY_EMAIL
            return false
        }

        if (!email.isValidEmail()) {
            emailError.value = INVALID_EMAIL
            return false
        }
        return true
    }

    override fun toData() = User(name.value, email.value)

}
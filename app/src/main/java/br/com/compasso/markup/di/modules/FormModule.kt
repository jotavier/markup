package br.com.compasso.markup.di.modules

import br.com.compasso.markup.data.forms.UserForm
import org.koin.dsl.module

val formModule = module {
    factory { UserForm() }
}
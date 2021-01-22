package br.com.compasso.markup.data.interfaces

interface IForm<T> {
    fun isValid(): Boolean
    fun toData(): T?
}
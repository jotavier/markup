package br.com.compasso.markup.data.interfaces

import android.os.Parcelable

interface IDataTransferObject<T> : Parcelable {
    fun toModel(): T
}
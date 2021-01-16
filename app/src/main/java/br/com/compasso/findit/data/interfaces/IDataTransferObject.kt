package br.com.compasso.findit.data.interfaces

import android.os.Parcelable

interface IDataTransferObject<T> : Parcelable {
    fun toModel(): T
}
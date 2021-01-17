package br.com.compasso.findit.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
@Entity
data class Event @JvmOverloads constructor(
    @PrimaryKey val id: Long,
    val date: Long,
    val description: String,
    @Ignore val people: List<Person>? = null,
    val image: String,
    val longitude: Double,
    val latitude: Double,
    val price: BigDecimal,
    val title: String
) : Parcelable
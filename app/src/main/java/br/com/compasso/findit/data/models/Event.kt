package br.com.compasso.findit.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class Event(
    @PrimaryKey val id: Long,
    val date: Long,
    val description: String,
    @Ignore val people: List<Person>,
    val image: String,
    val longitude: Double,
    val latitude: Double,
    val price: BigDecimal,
    val title: String
)
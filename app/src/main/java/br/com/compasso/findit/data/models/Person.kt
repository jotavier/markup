package br.com.compasso.findit.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Person(
    @PrimaryKey val name: String?,
    val email: String?,
    @ForeignKey(
        entity = Event::class,
        parentColumns = ["id"],
        childColumns = ["event_id"]
    )
    @ColumnInfo(name = "event_id") val eventId: Int?
) : Parcelable
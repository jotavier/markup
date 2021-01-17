package br.com.compasso.findit.data.models

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    indices = [
        Index(
            value = ["email", "event_id"],
            name = "ux_person_email_event_id",
            unique = true
        )
    ]
)
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val email: String,
    val name: String,
    @ForeignKey(
        entity = Event::class,
        parentColumns = ["id"],
        childColumns = ["event_id"]
    )
    @ColumnInfo(name = "event_id") val eventId: Int
) : Parcelable
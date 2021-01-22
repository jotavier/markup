package br.com.compasso.markup.data.models

import android.content.Context
import android.location.Geocoder
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import br.com.compasso.markup.services.extensions.toDate
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
@Entity
data class Event @JvmOverloads constructor(
    @PrimaryKey val id: Long,
    val date: Long,
    val description: String,
    @Ignore val people: List<String>? = null,
    val image: String,
    val longitude: Double,
    val latitude: Double,
    val price: BigDecimal,
    val title: String,
    var favorite: Boolean = false
) : Parcelable {

    private companion object {
        const val DATE_PATTERN = "dd-MM"
        const val SCHEDULE_PATTERN = "HH:mm"
    }

    fun address(context: Context): String {
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses = geocoder.getFromLocation(latitude, longitude, 10)
        val address = geocoder.getFromLocation(latitude, longitude, 1)[0]
        val street = address.thoroughfare
        val number = address.featureName
        val state = address.adminArea
        val locality = addresses.firstOrNull { it.locality != null }?.locality
        return if (locality != null) "$street, $number\n$locality / $state" else "$street, $number\n$state"

    }

    fun datePattern() = toPattern(DATE_PATTERN)

    fun schedulePattern() = toPattern(SCHEDULE_PATTERN)

    private fun toPattern(pattern: String): String {
        val formatter = SimpleDateFormat(pattern, Locale.getDefault())
        try {
            return formatter.format(this.date.toDate())
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return ""
    }
}
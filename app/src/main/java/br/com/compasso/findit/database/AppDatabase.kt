package br.com.compasso.findit.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.compasso.findit.data.models.Event
import br.com.compasso.findit.data.models.Person
import br.com.compasso.findit.database.converters.BigDecimalConverter

@Database(
    entities = [
        Event::class,
        Person::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(BigDecimalConverter::class)
abstract class AppDatabase : RoomDatabase() {
}
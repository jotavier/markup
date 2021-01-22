package br.com.compasso.markup.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.compasso.markup.data.models.Event
import br.com.compasso.markup.database.converters.BigDecimalConverter
import br.com.compasso.markup.database.daos.EventDAO

@Database(
    entities = [
        Event::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(BigDecimalConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val eventDAO: EventDAO
}
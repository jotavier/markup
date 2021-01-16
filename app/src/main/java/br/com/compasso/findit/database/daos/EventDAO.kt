package br.com.compasso.findit.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.compasso.findit.data.models.Event

@Dao
interface EventDAO {
    @Query("SELECT * FROM event")
    fun allEvents(): LiveData<List<Event>>

    @Insert
    fun save(events: List<Event>)
}
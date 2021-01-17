package br.com.compasso.findit.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.compasso.findit.data.models.Event

@Dao
interface EventDAO {
    @Query("SELECT * FROM event ORDER BY date ASC")
    fun all(): LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(events: List<Event>)
}
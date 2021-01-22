package br.com.compasso.markup.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.compasso.markup.data.models.Event

@Dao
interface EventDAO {
    @Query("SELECT * FROM event ORDER BY date ASC")
    fun all(): LiveData<List<Event>>

    @Query("SELECT * FROM event e WHERE e.favorite = 1")
    suspend fun allLocal(): List<Event>

    @Query("SELECT * FROM event e WHERE e.favorite = 1")
    fun favorites(): LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(events: List<Event>)

    @Update
    suspend fun update(event: Event): Int
}
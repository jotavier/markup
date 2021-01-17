package br.com.compasso.findit.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.compasso.findit.data.models.Person

@Dao
interface PersonDAO {
    @Query("SELECT p.* FROM event e INNER JOIN person p ON e.id = :eventId")
    fun from(eventId: Int): LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun save(person: Person)
}
package br.com.compasso.findit.database.daos

import androidx.room.Insert
import androidx.room.Query
import br.com.compasso.findit.data.models.Person

interface PersonDAO {
    @Query("SELECT * FROM person p WHERE p.event_id = :eventId")
    fun peopleFrom(eventId: Int)

    @Insert
    fun save(person: Person)
}
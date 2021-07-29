package com.alexfuster.reminder.repository.db.dao

import androidx.room.*
import com.alexfuster.reminder.repository.db.entities.ReminderEntity

@Dao
interface ReminderDao {


  @Query("SELECT * FROM table_reminder ORDER BY id DESC")
  fun getAll(): List<ReminderEntity>

  @Query("SELECT * FROM table_reminder WHERE id = :id")
  fun getById(id: Int): ReminderEntity

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(challenge: ReminderEntity)


  @Update
  fun update(challenge: ReminderEntity)

  @Delete
  fun delete(challenge: ReminderEntity)
}
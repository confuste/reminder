package com.alexfuster.reminder.repository.local.dao

import androidx.room.*
import com.alexfuster.reminder.repository.local.entities.ReminderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {


  @Query("SELECT * FROM table_reminder ORDER BY id DESC")
  fun getAll(): Flow<List<ReminderEntity>>

  @Query("SELECT * FROM table_reminder WHERE id = :id")
  fun getById(id: Int): ReminderEntity

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(reminder: ReminderEntity)

  @Update
  fun update(reminder: ReminderEntity)

  @Delete
  fun delete(reminder: ReminderEntity)
}
package com.alexfuster.reminder.repository.local

import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.local.entities.ReminderEntity
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
  fun getAll(): Flow<List<ReminderViewModel>>
  fun getById(id: Int): ReminderViewModel
  fun insert(reminder: ReminderEntity)
  fun update(reminder: ReminderEntity)
  fun delete(reminder: ReminderEntity)
}
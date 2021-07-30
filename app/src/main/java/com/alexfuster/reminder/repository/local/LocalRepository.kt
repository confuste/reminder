package com.alexfuster.reminder.repository.local

import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.local.entities.ReminderEntity
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
  fun getAll(): Flow<List<ReminderViewModel>>
  fun getById(id: Int): ReminderViewModel
  suspend fun insert(reminder: ReminderViewModel)
  suspend fun update(reminder: ReminderViewModel)
  suspend fun delete(reminder: ReminderViewModel)
}
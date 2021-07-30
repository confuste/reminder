package com.alexfuster.reminder.repository.local

import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.local.dao.ReminderDao
import com.alexfuster.reminder.repository.local.entities.ReminderEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class LocalRepositoryImp @Inject constructor(private val reminderDao: ReminderDao): LocalRepository {

  override fun getAll(): Flow<List<ReminderViewModel>> {
    return reminderDao.getAll().map {
      it.toReminderViewModel()
    }
  }

  override fun getById(id: Int): ReminderViewModel = reminderDao.getById(id).toReminderViewModel()


  override fun insert(reminder: ReminderEntity) {
    reminderDao.insert(reminder)
  }

  override fun update(reminder: ReminderEntity) {
    reminderDao.update(reminder)
  }

  override fun delete(reminder: ReminderEntity) {
    reminderDao.delete(reminder)
  }
}
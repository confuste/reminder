package com.alexfuster.reminder.repository.local

import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.local.dao.ReminderDao
import com.alexfuster.reminder.repository.local.entities.ReminderEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class LocalRepositoryImp @Inject constructor(private val reminderDao: ReminderDao): LocalRepository {

  /*
  override fun getAll(): Flow<List<ReminderViewModel>>  = flow {
    val reminderList: List<ReminderViewModel> = reminderDao.getAll().map {
      it.toReminderViewModel()
    }
    emit(reminderList)
  }
  */
   override fun getAll(): Flow<List<ReminderViewModel>> =
     reminderDao.getAll().map { it.toReminderViewModel() }


  override fun getById(id: Int): ReminderViewModel = reminderDao.getById(id).toReminderViewModel()


  override suspend fun insert(reminder: ReminderViewModel) {
    reminderDao.insert(reminder.toReminderEntity())
  }

  override suspend fun update(reminder: ReminderViewModel) {
    reminderDao.update(reminder.toReminderEntity())
  }

  override suspend fun delete(reminder: ReminderViewModel) {
    reminderDao.delete(reminder.toReminderEntity())
  }
}
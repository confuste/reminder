package com.alexfuster.reminder.app.di

import com.alexfuster.reminder.repository.db.dao.ReminderDao
import com.alexfuster.reminder.ui.add.AddReminderViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
class ActivityModule {


  @Provides
  fun provideAddReminderViewModel(reminderDao: ReminderDao) = AddReminderViewModel(reminderDao)


}
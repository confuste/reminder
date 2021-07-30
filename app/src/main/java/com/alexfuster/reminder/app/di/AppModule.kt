package com.alexfuster.reminder.app.di

import android.content.Context
import androidx.room.Room
import com.alexfuster.reminder.repository.local.database.AppDatabase
import com.alexfuster.reminder.repository.local.database.DBConstants
import com.alexfuster.reminder.repository.local.LocalRepository
import com.alexfuster.reminder.repository.local.LocalRepositoryImp
import com.alexfuster.reminder.repository.local.dao.ReminderDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

  @Singleton
  @Provides
  fun provideDatabaseRoomInstance(@ApplicationContext context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, DBConstants.DATABASE_NAME).build()

  @Singleton
  @Provides
  fun provideReminderDao(db: AppDatabase): ReminderDao = db.reminderDao()

  @Singleton
  @Provides
  fun provideLocalRepository(reminderDao: ReminderDao): LocalRepository =
    LocalRepositoryImp(reminderDao)

}
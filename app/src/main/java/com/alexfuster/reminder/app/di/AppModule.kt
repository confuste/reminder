package com.alexfuster.reminder.app.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexfuster.reminder.repository.db.AppDatabase
import com.alexfuster.reminder.repository.db.DBConstants
import com.alexfuster.reminder.repository.db.dao.ReminderDao
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

}
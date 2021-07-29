package com.alexfuster.reminder.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexfuster.reminder.repository.db.dao.ReminderDao
import com.alexfuster.reminder.repository.db.entities.ReminderEntity

@Database(entities = [ReminderEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

  abstract fun reminderDao(): ReminderDao

/* IN HILT
  fun create(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, DBConstants.DATABASE_NAME).build()
  }
 */

}
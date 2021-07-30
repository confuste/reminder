package com.alexfuster.reminder.repository.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_reminder")
data class ReminderEntity(
  @PrimaryKey
  val id: Int,

  @ColumnInfo(name = "name")
  val name: String,

  @ColumnInfo(name = "title")
  val title: String,

  @ColumnInfo(name = "text")
  val text: String,

  @ColumnInfo(name = "start_date")
  val startDate: Long,

  @ColumnInfo(name = "end_date")
  val endDate: Long

  )
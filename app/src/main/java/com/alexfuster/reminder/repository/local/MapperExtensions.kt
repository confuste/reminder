package com.alexfuster.reminder.repository.local

import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.local.entities.ReminderEntity

fun List<ReminderEntity>.toReminderViewModel(): List<ReminderViewModel> {
  return this.map {
    it.toReminderViewModel()
  }
}

fun ReminderEntity.toReminderViewModel(): ReminderViewModel =
  ReminderViewModel(id, name, title, text, startDate, endDate)

fun ReminderViewModel.toReminderEntity(): ReminderEntity =
  ReminderEntity(id, name, title, text, startDate, endDate)


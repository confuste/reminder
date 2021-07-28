package com.alexfuster.reminder.model.modelview

data class ReminderViewModel(val id: Int, val name: String, val title: String, val text: String,
                             val startDate: Long, val endDate: Long)

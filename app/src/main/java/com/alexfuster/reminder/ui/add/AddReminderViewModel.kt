package com.alexfuster.reminder.ui.add

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.db.dao.ReminderDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddReminderViewModel @Inject constructor(private val reminderDao: ReminderDao) : ViewModel() {

  private val _isAdded = MutableStateFlow(false)
  val isAdded: StateFlow<Boolean>
    get() = _isAdded


  fun addReminder(reminder: ReminderViewModel) {
    viewModelScope.launch {

      withContext(Dispatchers.IO) {
        Log.i("Alex", "ReminderDAO ${reminderDao.hashCode()}")
      }

      _isAdded.value = true

    }
  }
}
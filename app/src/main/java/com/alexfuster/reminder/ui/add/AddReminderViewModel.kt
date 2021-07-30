package com.alexfuster.reminder.ui.add

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.local.LocalRepository
import com.alexfuster.reminder.repository.local.dao.ReminderDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddReminderViewModel @Inject constructor(private val localRepository: LocalRepository) : ViewModel() {

  private val _isAdded = MutableStateFlow(false)
  val isAdded: StateFlow<Boolean>
    get() = _isAdded


  fun addReminder(reminder: ReminderViewModel) {
    viewModelScope.launch {

      withContext(Dispatchers.IO) {
        Log.i("Alex", "ReminderDAO ${localRepository.hashCode()}")
      }

      _isAdded.value = true

    }
  }
}
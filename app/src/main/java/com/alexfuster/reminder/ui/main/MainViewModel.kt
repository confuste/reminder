package com.alexfuster.reminder.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.repository.local.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val localRepository: LocalRepository) : ViewModel() {

  private val _reminderList = MutableStateFlow<List<ReminderViewModel>>(emptyList())
  val reminderList: StateFlow<List<ReminderViewModel>>
    get() =_reminderList

  init {
    observeLocalRepository()
  }

  private fun observeLocalRepository() {
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        localRepository.getAll().collect {
          _reminderList.value = it
        }
      }
    }
  }
}
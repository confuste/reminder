package com.alexfuster.reminder.ui.add

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.alexfuster.reminder.databinding.FragmentAddReminderBinding
import com.alexfuster.reminder.model.modelview.ReminderViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class AddReminderFragment: Fragment() {

  private val viewModel: AddReminderViewModel by viewModels()

  private var _binding: FragmentAddReminderBinding? = null
  private val binding
    get() = _binding!!



  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View {
    _binding = FragmentAddReminderBinding.inflate(inflater, container, false)


    subscribeViewModelObservers()

    viewModel.addReminder(ReminderViewModel(0, "alex", "titulo", "texto", 0,0))

    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

  private fun subscribeViewModelObservers() {
    lifecycleScope.launchWhenStarted {
      viewModel.isAdded.collect { Log.i("Alex", "fue añadido? $it")}
    }
  }

}
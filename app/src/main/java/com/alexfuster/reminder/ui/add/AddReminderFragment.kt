package com.alexfuster.reminder.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexfuster.reminder.databinding.FragmentAddReminderBinding


class AddReminderFragment: Fragment() {

  private var _binding: FragmentAddReminderBinding? = null
  private val binding
    get() = _binding!!



  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {

    _binding = FragmentAddReminderBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }


}
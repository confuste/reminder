package com.alexfuster.reminder.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexfuster.reminder.R
import com.alexfuster.reminder.databinding.FragmentMainBinding
import com.alexfuster.reminder.model.modelview.ReminderViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment() {

  private val viewModel: MainViewModel by viewModels()


  private var _binding: FragmentMainBinding? = null
  private val binding
    get() = _binding!!

  private lateinit var adapter: RecyclerViewAdapter


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    _binding = FragmentMainBinding.inflate(inflater, container, false)

    configureUIAndObservers()

    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }


  private fun configureUIAndObservers() {
    initRecyclerView()
    setClickListeners()
    subscribeViewModelObservers()
  }



  private fun initRecyclerView() {
    binding.rvReminders.layoutManager = LinearLayoutManager(context)
    adapter = RecyclerViewAdapter(this::onClickItemListener, this::onClickItemMenuListener)
    binding.rvReminders.adapter = adapter
    adapter.submitList(emptyList())
  }

  private fun setClickListeners() {
    binding.fabAddReminder.setOnClickListener(
      Navigation.createNavigateOnClickListener(R.id.action_main_fragment_to_add_reminder_fragment))
  }

  private fun subscribeViewModelObservers() {
    lifecycleScope.launchWhenStarted {
      viewModel.reminderList.collect {
        adapter.submitList(it)
        Log.i("Alex", "Actualiza la lista en el MainFragment")
      }
    }
  }


  private fun onClickItemListener(position: Int, item: ReminderViewModel) {


  }
  private fun onClickItemMenuListener(position: Int, item: ReminderViewModel, view: View) {


  }


}
package com.alexfuster.reminder.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexfuster.reminder.R
import com.alexfuster.reminder.databinding.FragmentMainBinding
import com.alexfuster.reminder.model.modelview.ReminderViewModel

class MainFragment : Fragment() {

  private var _binding: FragmentMainBinding? = null
  private val binding
    get() = _binding!!

  private lateinit var adapter: RecyclerViewAdapter


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    _binding = FragmentMainBinding.inflate(inflater, container, false)

    configureUI()

    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }


  private fun configureUI() {
    initRecyclerView()
    initListeners()
  }

  private fun initRecyclerView() {
    binding.rvChallenges.layoutManager = LinearLayoutManager(context)
    adapter = RecyclerViewAdapter(this::onClickItemListener, this::onClickItemMenuListener)
    binding.rvChallenges.adapter = adapter
    adapter.submitList(emptyList())
  }

  private fun initListeners() {
    binding.fabAddReminder.setOnClickListener(
      Navigation.createNavigateOnClickListener(R.id.action_main_fragment_to_add_reminder_fragment))
  }


  private fun onClickItemListener(position: Int, item: ReminderViewModel) {


  }
  private fun onClickItemMenuListener(position: Int, item: ReminderViewModel, view: View) {


  }


}
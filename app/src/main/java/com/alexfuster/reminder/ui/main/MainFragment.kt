package com.alexfuster.reminder.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexfuster.reminder.databinding.FragmentMainBinding
import com.alexfuster.reminder.model.modelview.ReminderViewModel

class MainFragment : Fragment() {

  private var _binding: FragmentMainBinding? = null
  private val binding
    get() = _binding!!

  private lateinit var adapter: RecyclerViewAdapter


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    _binding = FragmentMainBinding.inflate(inflater, container, false)

    configureUI();

    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }


  private fun configureUI() {
    initRecyclerView()
  }


  private fun initRecyclerView() {

    val item1 = ReminderViewModel(0, "alex", "titulo", "texto aqui", 1861920000000, 1893456000000)
    val item2 = ReminderViewModel(1, "alex", "titulo", "texto aqui", 1861920000000, 1893456000000)
    val lista = listOf(item1, item2)

    binding.rvChallenges.layoutManager = LinearLayoutManager(context)
    adapter = RecyclerViewAdapter(this::onClickItemListener, this::onClickItemMenuListener)
    binding.rvChallenges.adapter = adapter
    adapter.submitList(lista)
  }



  private fun onClickItemListener(position: Int, item: ReminderViewModel) {


  }
  private fun onClickItemMenuListener(position: Int, item: ReminderViewModel, view: View) {


  }


}
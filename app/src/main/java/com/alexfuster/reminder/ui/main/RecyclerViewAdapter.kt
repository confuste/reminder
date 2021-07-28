package com.alexfuster.reminder.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexfuster.reminder.R
import com.alexfuster.reminder.databinding.CellReminderBinding
import com.alexfuster.reminder.model.modelview.ReminderViewModel
import com.alexfuster.reminder.utils.getDaysLeftFromToday

class RecyclerViewAdapter(private val onClickItem: (position: Int, item: ReminderViewModel) -> Unit,
                          private val onClickMenu: (position: Int, item: ReminderViewModel, view: View) -> Unit)
  : ListAdapter<ReminderViewModel, RecyclerViewAdapter.ViewHolder>(DiffUtilCallback)  {



  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view: View = LayoutInflater.from(parent.context)
      .inflate(R.layout.cell_reminder, parent, false)

    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(position, getItem(position), onClickItem, onClickMenu)
  }


  class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CellReminderBinding.bind(view)

    fun bind(position: Int,
             item: ReminderViewModel,
             onClickItem: (position: Int, item: ReminderViewModel) -> Unit,
             onClickMenu: (position: Int, item: ReminderViewModel, view: View) -> Unit)
    = with(binding) {

      tvName.text = item.name
      tvTitle.text = item.title
      tvBodyText.text = item.text

      val daysLeft: Long = item.endDate.getDaysLeftFromToday()
      tvTimeLeft.text = view.resources.getString(R.string.time_left, daysLeft.toString())

      val acronymName: String = item.name.take(2)
      binding.tvAvatar.text = acronymName

      cvCardView.setOnClickListener { onClickItem(position, item) }
      ibCardMenu.setOnClickListener { onClickMenu(position, item, view) }
    }
  }
}

private object  DiffUtilCallback : DiffUtil.ItemCallback<ReminderViewModel>() {
  override fun areItemsTheSame(oldItem: ReminderViewModel, newItem: ReminderViewModel): Boolean =
    oldItem.id == newItem.id


  override fun areContentsTheSame(oldItem: ReminderViewModel, newItem: ReminderViewModel): Boolean =
    oldItem == newItem

}
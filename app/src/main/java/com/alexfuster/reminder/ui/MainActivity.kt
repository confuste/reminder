package com.alexfuster.reminder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.alexfuster.reminder.R
import com.alexfuster.reminder.databinding.ActivityMainBinding
import com.alexfuster.reminder.repository.db.dao.ReminderDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    navController =  Navigation.findNavController(this, R.id.nav_host_fragment)
    //NavigationUI.setupActionBarWithNavController(this, navController)
  }

  override fun onSupportNavigateUp(): Boolean {
    navController.navigateUp()
    return super.onSupportNavigateUp()

  }
}
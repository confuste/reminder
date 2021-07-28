package com.alexfuster.reminder.utils

import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

fun getTimestamp(): Long = Date().time

fun Long.getDifferenceDays(future: Long): Long {
  val diff: Long = abs(future - this)
  return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
}

fun Long.getDaysLeftFromToday(): Long {
  val today: Long = getTimestamp()
  return when {
    this <= today -> 0
    else -> this.getDifferenceDays(today)
  }
}
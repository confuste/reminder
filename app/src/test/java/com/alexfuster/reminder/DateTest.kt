package com.alexfuster.reminder

import com.alexfuster.reminder.utils.getDaysLeftFromToday
import com.alexfuster.reminder.utils.getDifferenceDays
import org.junit.Assert
import org.junit.Test
import java.util.*

class DateTest {

  @Test
  fun whenDateIsTheFuture_shouldBePositiveNumber() {
    val timestampFirstDayJanuary2029: Long = 1861920000000
    val timestampFirstDayJanuary2030: Long = 1893456000000
    val differenceDays = timestampFirstDayJanuary2029.getDifferenceDays(timestampFirstDayJanuary2030)
    Assert.assertEquals("Difference should be 365 days",365, differenceDays)
  }

  @Test
  fun whenDateIsTheSameTime_shouldBeZero() {
    val timestampFirstDayJanuary2029: Long = 1861920000000
    val differenceDays = timestampFirstDayJanuary2029.getDifferenceDays(timestampFirstDayJanuary2029)
    Assert.assertEquals("Difference should be 0 days",0, differenceDays)
  }

  @Test
  fun whenDateIsOnlyOneDayOfDifference_shouldBeOneDay() {
    val timestampFirstDayJanuary2029: Long = 1861920000000
    val timestampSecondDayJanuary2029: Long = 1862006400000

    val differenceDays = timestampFirstDayJanuary2029.getDifferenceDays(timestampSecondDayJanuary2029)
    Assert.assertEquals("Difference should be 1 days",1, differenceDays)
  }

  @Test
  fun whenDateIsOnly22HoursOfDifference_shouldBeZero() {
    val timestampFirstDayJanuary2029: Long = 1861920000000
    val timestampFirstDayJanuary2029And22HoursMore: Long = 1861999200000

    val differenceDays = timestampFirstDayJanuary2029.getDifferenceDays(timestampFirstDayJanuary2029And22HoursMore)
    Assert.assertEquals("Difference should be 0 days",0, differenceDays)
  }

  @Test
  fun whenIsPreviousDate_shouldBePositiveNumber() {
    val timestampFirstDayJanuary2029: Long = 1861920000000
    val timestampFirstDayJanuary2030: Long = 1893456000000
    val differenceDays = timestampFirstDayJanuary2030.getDifferenceDays(timestampFirstDayJanuary2029)
    Assert.assertEquals("Difference should be 365 days",365, differenceDays)
  }


  @Test
  fun whenTodayIsThePast_shouldBeZero() {
    val timestampInThePast: Long = 1546300800000
    val daysLeft = timestampInThePast.getDaysLeftFromToday()
    Assert.assertEquals("Days left should be 0 days",0, daysLeft)
  }


  @Test
  fun whenDateIsToday_shouldBeZero() {
    val timestampInThePast: Long = Date().time
    val daysLeft = timestampInThePast.getDaysLeftFromToday()
    Assert.assertEquals("Days left should be 0 days", 0, daysLeft)
  }

  @Test
  fun whenDateIsFuture_shouldBePositive() {
    val timestampInTheFuture2030: Long = 1893456000000
    val daysLeft = timestampInTheFuture2030.getDaysLeftFromToday()
    Assert.assertTrue("Days left should be more than 0", daysLeft  > 0);
  }

}
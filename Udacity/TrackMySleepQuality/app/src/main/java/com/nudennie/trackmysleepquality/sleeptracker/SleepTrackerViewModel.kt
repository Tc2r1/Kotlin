/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nudennie.trackmysleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.*
import com.nudennie.trackmysleepquality.database.SleepDatabaseDao
import com.nudennie.trackmysleepquality.database.SleepNight
import com.nudennie.trackmysleepquality.formatNights
import kotlinx.coroutines.*

/**
 * ViewModel for SleepTrackerFragment.
 */
class SleepTrackerViewModel(
    val database : SleepDatabaseDao, application : Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var tonight = MutableLiveData<SleepNight?>()

    // Get all nights in the database when we create the viewModel
    private val nights = database.getAllNights()

    /**
     * Converted nights to Spanned for displaying.
     */
    val nightsString = Transformations.map(nights) { nights ->
        formatNights(nights, application.resources)
    }

    val startButtonVisible = Transformations.map(tonight) {
        // if tonight is null, we want the response to be "true" aka visible.
        null == it
    }

    val stopButtonVisible = Transformations.map(tonight) {
        // if tonight is set, we want the response to be "true" aka visible.
        null != it
    }

    val clearButtonVisible = Transformations.map(nights) {
        // only visible if there are nights to clear.
        it?.isNotEmpty()
    }

    /**
     * Request a toast by setting this value to true.
     *
     * This is private because we don't want to expose setting this value to the Fragment.
     */
    private var _showSnackBarEvent = MutableLiveData<Boolean>()

    /**
     * If this is true, immediately `show()` a toast and call `onSnackBarFinished()`.
     */
    val showSnackBarEvent : LiveData<Boolean>
        get() = _showSnackBarEvent

    fun onSnackBarFinished() {
        _showSnackBarEvent.value = false
    }

    /**
     * Variable that tells the Fragment to navigate to a specific [SleepQualityFragment]
     *
     * This is private because we don't want to expose setting this value to the Fragment.
     */
    private val _navigateToSleepQuality = MutableLiveData<SleepNight>()

    /**
     * If this is non-null, immediately navigate to [SleepQualityFragment] and call [doneNavigating]
     */
    val navigateToSleepQuality : LiveData<SleepNight>
        get() = _navigateToSleepQuality

    /**
     * Call this immediately after calling `show()` on a toast.
     *
     * It will clear the toast request, so if the user rotates their phone it won't show a duplicate
     * toast.
     */
    fun onNavigationFinished() {
        _navigateToSleepQuality.value = null
    }

    init {

        initializeTonight()
    }

    private fun initializeTonight() { // We use coroutine to get tonight from database
        // so we don't block ui while waiting for result.
        uiScope.launch {
            tonight.value = getTonightFromDatabase()
        }
    }

    /**
     *  Handling the case of the stopped app or forgotten recording,
     *  the start and end times will be the same.j
     *
     *  If the start time and end time are not the same, then we do not have an unfinished
     *  recording.
     */
    private suspend fun getTonightFromDatabase() : SleepNight? {
        return withContext(Dispatchers.IO) {
            var night = database.getTonight()
            if (night?.endTimeMilli != night?.startTimeMilli) {
                night = null
            }
            night
        }
    }

    /**
     * Executes when the START button is clicked.
     */
    fun onStartTracking() {
        uiScope.launch {
            // Create a new night, which captures the current time,
            // and insert it into the database.
            val newNight = SleepNight()
            insert(newNight)

            tonight.value = getTonightFromDatabase()
        }
    }

    private suspend fun insert(night : SleepNight) {
        withContext(Dispatchers.IO) {
            database.insert(night)
        }
    }

    /**
     *Executes when the stop button is clicked.
     */
    fun onStopTracking() {
        uiScope.launch {
            /*
            * In Kotlin, the return@label syntax is used for specifying which function among several nested
            * ones this statement returns from.
            * In this case, we are specifying to return from launch(), not the lambda
            * */
            val oldNight = tonight.value ?: return@launch

            // Update the night in the database to add the end time.
            oldNight.endTimeMilli = System.currentTimeMillis()
            update(oldNight)


            _navigateToSleepQuality.value = oldNight
        }
    }

    private suspend fun update(night : SleepNight) {
        withContext(Dispatchers.IO) {
            database.update(night)
        }
    }

    fun onClear() {
        uiScope.launch {
            clear()
            tonight.value = null
            _showSnackBarEvent.value = true
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
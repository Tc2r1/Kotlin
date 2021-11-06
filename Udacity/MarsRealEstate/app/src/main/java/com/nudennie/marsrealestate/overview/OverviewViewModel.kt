package com.nudennie.marsrealestate.overview

import androidx.lifecycle.*
import com.nudennie.marsrealestate.network.MarsApi
import com.nudennie.marsrealestate.network.MarsProperty
import kotlinx.coroutines.*

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val status: LiveData<String>
        get() = _status

    private val _property = MutableLiveData<MarsProperty>()
    val property: LiveData<MarsProperty>
        get() = _property

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {
        coroutineScope.launch {
            val getPropertiesDeferred = MarsApi.retrofitService.getProperties()
            try {
                val listResults = getPropertiesDeferred.await()
                if(listResults.isNotEmpty()) {
                    _property.value = listResults[0]
                }
            } catch(t:Throwable) {
                _status.value = "Failure: ${t.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

package com.nudennie.marsrealestate.overview

import androidx.lifecycle.*
import com.nudennie.marsrealestate.network.MarsApi
import com.nudennie.marsrealestate.network.MarsProperty
import kotlinx.coroutines.*


enum class MarsApiStatus {
    LOADING,
    ERROR,
    DONE
}

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the request status String
    val status: LiveData<MarsApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties: LiveData<List<MarsProperty>>
        get() = _properties

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
                _status.value = MarsApiStatus.LOADING
                val listResults = getPropertiesDeferred.await()
                _status.value = MarsApiStatus.DONE
                if(listResults.isNotEmpty()) {
                    _properties.value = listResults
                }
            } catch(t: Throwable) {
                _status.value = MarsApiStatus.ERROR
                _properties.value = emptyList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

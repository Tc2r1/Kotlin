package com.nudennie.guesstheword.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ScoreViewModel(finalScoreValue: Int): ViewModel() {


    private var _finalScore = MutableLiveData<Int>()
    private var _playAgainEvent = MutableLiveData<Boolean>()

    // Encapsulation using Backing Properties
    val finalScore: LiveData<Int> get() = _finalScore
    val playAgainEvent: LiveData<Boolean> get() = _playAgainEvent


    init {
        _finalScore.value = finalScoreValue
        _playAgainEvent.value = false
        Timber.i("Final Score is $finalScoreValue")
    }

    fun onPlayAgain() {
        _playAgainEvent.value = true
    }

    fun onPlayAgainComplete() {
        _playAgainEvent.value = false
    }
}
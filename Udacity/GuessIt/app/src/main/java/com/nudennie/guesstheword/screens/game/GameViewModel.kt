package com.nudennie.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nudennie.guesstheword.screens.game.GameViewModel.BuzzType.*
import timber.log.Timber


private val CORRECT_BUZZ_PATTERN = longArrayOf(100, 50, 50, 100, 100, 100)
private val PANIC_BUZZ_PATTERN = longArrayOf(0, 200)
private val GAME_OVER_BUZZ_PATTERN = longArrayOf(0, 1500)
private val NO_BUZZ_PATTERN = longArrayOf(0)


class GameViewModel : ViewModel() {

    enum class BuzzType(val pattern: LongArray) {
        CORRECT(CORRECT_BUZZ_PATTERN),
        GAME_OVER(GAME_OVER_BUZZ_PATTERN),
        COUNTDOWN_PANIC(PANIC_BUZZ_PATTERN),
        NO_BUZZ(NO_BUZZ_PATTERN)
    }

    companion object {
        // These represent different important times
        // This is when the game is over
        private const val DONE = 0L

        // This is the time when the phone will start buzzing each second
        private const val COUNTDOWN_PANIC_SECONDS = 10L

        // This is the number of milliseconds in a second
        private const val ONE_SECOND = 1000L

        // This is the total time of the game (60 seconds)
        private const val COUNTDOWN_TIME = 20000L
    }

    private val timer: CountDownTimer

    // The current word and current score
    private var _word = MutableLiveData<String>()
    private var _score = MutableLiveData<Int>()
    private var _eventGameFinished = MutableLiveData<Boolean>()
    private var _currentTime = MutableLiveData<Long>()


    // Encapsulation using Backing Properties.
    val word: LiveData<String> get() = _word
    val score: LiveData<Int> get() = _score
    val eventGameFinished: LiveData<Boolean> get() = _eventGameFinished
    val currentTime: LiveData<Long> get() = _currentTime
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    // Event that triggers the phone to buzz using different patterns, determined by BuzzType
    private val _eventBuzz = MutableLiveData<BuzzType>()
    val eventBuzz: LiveData<BuzzType>
        get() = _eventBuzz

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        _eventGameFinished.value = false
        _score.value = 0
        Timber.i("GameViewModel created!")
        resetList()
        nextWord()
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                // count down
                _currentTime.value = millisUntilFinished / ONE_SECOND
                if (millisUntilFinished / ONE_SECOND <= COUNTDOWN_PANIC_SECONDS) {
                    _eventBuzz.value = BuzzType.COUNTDOWN_PANIC
                }
            }

            override fun onFinish() {
                // End the game.
                _currentTime.value = DONE
                _eventGameFinished.value = true
                _eventBuzz.value = GAME_OVER
            }
        }

        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed!")
        timer.cancel()
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            resetList()
        }
        _word.value = wordList.removeAt(0)

    }

    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        _eventBuzz.value = CORRECT
        nextWord()
    }

    fun onBuzzCompelte() {
        _eventBuzz.value = NO_BUZZ
    }

    fun onGameFinishedComplete() {
        _eventGameFinished.value = false
    }
}
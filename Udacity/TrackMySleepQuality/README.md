# Room - SleepQualityTracker app

This is the toy app for Lesson 6 of the [Android App Development in Kotlin course on Udacity](https://www.udacity.com/course/???).

## SleepQualityTracker

The SleepQualityTracker app is a demo app that helps you collect information about your sleep. 
* Start time
* End time
* Quality
* Time slept

This app demonstrates the following views and techniques:
* Room database
* DAO
* Coroutines

It also uses and builds on the following techniques from previous lessons:
* Transformation map
* Data Binding in XML files
* ViewModel Factory
* Using Backing Properties to protect MutableLiveData
* Observable state LiveData variables to trigger navigation

## Screenshots

![Screenshot1](screenshots/sleep_quality_tracker_start.png)
![Screenshot2](screenshots/sleep_quality_tracker_stop.png)
![Screenshot3](screenshots/sleep_quality_tracker_quality.png)


## Tc2r1's Notes: 

* Scheduler handles priorities and makes sure all threads finish.
* Dispatcher sets up threads
* Main thread runs in the foreground, and can dispatch other threads.
* Main thread handles all updates to the UI and calls all click handlers and other UI and lifecycle callbacks.
* If you block the Main thread for too long, it will stutter or even freeze, it can crash with ApplicationNotResponding.


**COROUTINES**

Coroutines handle long running task elegantly and efficiently.

Coroutines can signal errors with exceptions.

Coroutines are Asynchronous

- The coroutine runs independently from the main execution steps of the program.

Coroutines are Non-blocking

- The system is not blocking the main or UI thread.

Coroutines are Sequential
- Suspend allows other work to happen while waiting for response

**JOB**

- A background job. Conceptually a job is a cancellable thing with a life-cycle that culminates in its completion.
- Jobs can be arranged in a parent child hierarchy, so that cancelling a parent cancels the child coroutines.

**Dispatcher**

- Sends off coroutines to run on various threads.

**Scope**

- The scope combines information, including a job and dispatcher, to define the context in which the coroutine runs.
- Scopes keep track of coroutines.


In fragment first reference application = this.activity.application

Arguements = FragmentArgs.fromBundle(arguements)

dataSource = database.getInstance(application).dao

Factory = Factory(safeargs)

VieModal = ViewModelProvider(owner, factory)[class]

## Tc2r1's RECAP

* Used a Room Database to store retrieve and update my data.
* Created a sleepNights data class to define a database table and it's structure.
* Made a Data Access Object to define the API for our database, creating mappings between kotlin functions and SQLite queries.
* I made a room database singleton.
* ViewModelFactory for dependency injection.
* Added ViewModels to manage database operations and handle user clicks.
* Used Coroutines to make sure the database operations don't interfere with a smooth user experience.
* Implemented Observable state variables to keep UI operations, such as navigation in the fragment.
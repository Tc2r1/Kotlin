# Coroutines - Kotlin Coroutines App. 

This is the app for the [Android.com Developer's CodeLab for Kotlin Coroutines](https://developer.android.com/codelabs/kotlin-coroutines).

## Coroutines

This starter app uses threads to increment the count a short delay after you press the screen. 
It will also fetch a new title from the network and display it on screen. 
In this CodeLab I will convert this application to use coroutines

This app demonstrates the following knowledge.
* The ability to Call code written with coroutines and obtain results.
* I will Use suspend functions to make async code sequential.
* I will Use launch and runBlocking to control how code executes.
* I will gain knowledge of techniques to convert existing APIs to coroutines using suspendCoroutine.
* I will Use coroutines with Architecture Components.
* I will show  best practices for testing coroutines.

[comment]: <> (## Screenshots)

[comment]: <> (![Screenshot1]&#40;screenshots/sleep_quality_tracker_start.png&#41;)
[comment]: <> (![Screenshot2]&#40;screenshots/sleep_quality_tracker_stop.png&#41;)
[comment]: <> (![Screenshot3]&#40;screenshots/sleep_quality_tracker_quality.png&#41;)


## Tc2r1's Notes:


*Callbacks*

Code that heavily uses callbacks can become hard to read and harder to reason about. In addition, callbacks don't allow the use of some language features, such as exceptions.

Kotlin coroutines lets you convert callback-based code to sequential code. Code written *sequentially* is typically easier to read and can even use language features such as Exceptions!


**Suspend**

The keyword suspend is Kotlin's way of marking a function, or function type, available to coroutines. When a coroutine calls a function marked suspend, instead of blocking until that function returns like a normal function call, it suspends execution until the result is ready then it resumes where it left off with the result. While it's suspended waiting for a result, it unblocks the thread that it's running on so other functions or coroutines can run.


**CoroutineScope**

In Kotlin, all coroutine run inside a coroutineScope. A scope controls the lifetime of coroutines through its job.
when you cancel the job of a scope, it cancels all coroutines started in that scope. 



** Dispatchers**

For coroutines started by the UI, it is typically correct to start them on Dispatchers.Main which is the main thread on Android. A coroutine started on Dispatchers.Main won't block the main thread while suspended. Since a ViewModel coroutine almost always updates the UI on the main thread, starting coroutines on the main thread saves you extra thread switches. A coroutine started on the Main thread can switch dispatchers any time after it's started. For example, it can use another dispatcher to parse a large JSON result off the main thread.

The AndroidX lifecycle-viewmodel-ktx library adds a CoroutineScope to ViewModels that's configured to start UI-related coroutines.

The library adds a viewModelScope as an extension function of the ViewModel class. This scope is bound to Dispatchers.Main and will automatically be cancelled when the ViewModel is cleared.


**TESTING**

A **rule** is a way to run code before and after the execution of a test in JUnit.

**InstantTaskExecutorRule** is a JUnit rule that configures LiveData to execute each task synchronously.

**MainCoroutineScopeRule** is a custom rule in this codebase that configures Dispatchers.Main to use a TestCoroutineDispatcher from kotlinx-coroutines-test. This allows tests to advance a virtual-clock for testing, and allows code to use Dispatchers.Main in unit tests.

**WorkManager** is a compatible, flexible, and simple library for deferrable background work. 

##Remarks

In this codelab I have covered the basics I'll need to start using coroutines in my app!

    How to integrate coroutines to Android apps from both the UI and WorkManager jobs to simplify asynchronous programming,
    How to use coroutines inside a ViewModel to fetch data from the network and save it to a database without blocking the main thread.
    And how to cancel all coroutines when the ViewModel is finished.

For testing coroutine based code, I covered both by testing behavior and directly calling suspend functions from tests.




















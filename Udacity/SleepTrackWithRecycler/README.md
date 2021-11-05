# RecyclerView - SleepQualityTracker with RecyclerView app

This is the toy app for Lesson 7 of the [Android App Development in Kotlin course on Udacity](https://classroom.udacity.com/courses/ud9012/).


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
## SleepQualityTracker with RecyclerView

This app builds on the SleepQualityTracker you developed in Lesson 6.  In this lesson you'll learn how to display a list of results in a RecyclerView instead of a static ScrollView. You'll also learn how you can refactor your code to make it more efficient so it will be easier to maintain and test.

## Screenshots

![Screenshot1](screenshots/sleep_tracker_recycler_home.png)
![Screenshot2](screenshots/sleep_tracker_recycler_detail.png)

Tc2r's Remarks:

In this lesson I covered the basics of RecyclerView, what an adapter is, how to implement a recyclerview adapter
and a ViewHolder.

How to use DiffUtils to optimize updating the data in the recyclerview.
* By using DiffUtils updating a single element in the list will only update that view on the scren.

How to integrate Databnding into a recyclerview adapter.
* This shortens the code of the View ViewHolder
* Better structures the code.

How to use Binding Adapters to update views. 
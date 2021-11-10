# Behind the Scenes - DevByte Viewer App

This is the toy app for Lesson 9 of the [Android App Development in Kotlin course on Udacity](https://classroom.udacity.com/courses/ud9012).

## DevByte

DevByte Viewer is an example app that showcases using 
[Room](https://developer.android.com/topic/libraries/architecture/room) and a Repository to create
an offline cache.

In addition, it also covers how to use 
[WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager) for scheduling
periodic work. In this app it's used to setup a daily background data sync.

## Screenshots

![Screenshot1](screenshots/devbyte-homescreen.png)

## Tc2r1's Notes:

Dao Offline caches need to methods. 
One to Load values from the cache. and One to store values. 

Varargs are variable arguments and allow a function to take an array of arguments.
asterisk * is the spread operator. It allows you to pass in an array to a function that expects varargs.

We can use OnConflictSStrategy to replace old cache values with new ones. 

The repository helps clean up the code, makes classes with well defined APIs to help accomplish task easier. 
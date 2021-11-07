# Connect to the Internet - Mars Real Estate

This is the toy app for Lesson 8 of the [Android App Development in Kotlin course on Udacity](https://classroom.udacity.com/courses/ud9012/).

## MarsRealEstate

MarsRealEstate is a simple demo app using ViewModel & LiveData with Retrofit, Glide and Moshi in Kotlin.

This app demonstrates the following views and techniques:

* [Retrofit](https://square.github.io/retrofit/) to make api calls to an HTTP web service
* [Moshi](https://github.com/square/moshi) which handles the deserialization of the returned JSON to Kotlin data objects 
* [Glide](https://bumptech.github.io/glide/) to load and cache images by URL.
  
It leverages the following components from the Jetpack library:

* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) with binding adapters
* [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) with the SafeArgs plugin for parameter passing between fragments

## Screenshots

![Screenshot 1](screenshots/screen_1.png)
![Screenshot 2](screenshots/screen_2.png)
![Screenshot 3](screenshots/screen_3.png)



## Tc2r's Notes

[Scalar](https://square.github.io/retrofit/) is a library that allows retrofit to return the json result as a String.

Retrofit is a library that creates a network API for an application. Based on the content from a web service

The Network Layer is the Api that the ViewModel will use to communicate with a web service.


The Moshi Library parses Json into Json Objects


**Retrofit  has Coroutine Support**

Using the Library "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:" Retrofit is able 
to add a CoroutineCallAdapterFactory.

This enables retrofit to produce a Coroutine based Api.
The CoroutineCallAdapterFactory allows the ability to replace the "Call" in the Service methods with Deferred from Coroutines.

Deferred is a type of non-blocking Cancellable job that can directly return a result.

Because Retrofit does everything on a background thread, we can use the UI thread andd dont need any other threads. 

When using CoroutineScope/ Jobs in ViewModel, don't forget to cancel them in the OnClear Lifecycle.

Built a bindingAdapter that takes the url from an xml attribute associated with an imageview and use glide to load the image

Parcelling is a way of sharing objects between different processes by flattening objects into a stream of data called a Parcel.  


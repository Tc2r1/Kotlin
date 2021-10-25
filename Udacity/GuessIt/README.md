# Application Architecture - The UI Layer - Guess It!
This is the toy app for lesson 5 of the [Android App Development in Kotlin course on Udacity](https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012).

## Guess It!

Guess It is a word guessing app you can play with one or more friends. To play, hold the device in landscape, facing away from you with your thumbs on the **Skip** and **Got It** buttons. Your friends can then give you clues to help you guess the word. 

If you get the word right, press **Got It**. If you're stuck, press **Skip**. The game runs for a minute and then shows you your score.


## Screenshots

![Screenshot 0](screenshots/screen0.png) ![Screenshot 1](screenshots/screen1.png) ![Screenshot 2](screenshots/screen2.png)

## Nudennie's Notes on Project: 

Software design principle this app will exemplify is 

**Separation of Concerns** Divide your code into classes, each with separate, well-defined responsibilities
Code is more Organized and Easier to debug. Code is much more Modular

**Drive UI from a model** Models are components that are responsible for handling the data for an app. Independent from the UI Controller (View objects)
and app components in the app. They are unaffected by the app's lifecycle. 


**UI Controller** (Fragments/Activities) Displays data and captures OS and user events (user touches).

**ViewModel** Holds all of the data needed for the UI and prepares it for display (this is where calculations are done), Holds LiveData classes
ViewModel survives configuration changes. 

**LiveData** LiveData classes are crucial for communicating information from the viewModel to the UI Controller that it should upadate and redraw the screen.
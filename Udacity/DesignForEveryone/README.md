# Designing for Everyone - GDG Finder app

This is the toy app for Lesson 10 of the [Android App Development in Kotlin course on Udacity](https://classroom.udacity.com/courses/ud9012/).

## GDG Finder

GDGs, or Google Developer Groups, are communities of developers that focus on Google technologies - including Android - around the world. They host lots of different events like meetups, conferences, study jams, and more!

GDG Finder helps you locate GDGs around the world or start one of your own. You'll learn the principles of Material Design so you can implement professional looking designs and build Android apps that users love to use!


## Screenshots

![Screenshot1](screenshots/gdg-finder-home.png)
![Screenshot2](screenshots/gdg-finder-search.png)
![Screenshot3](screenshots/gdg-finder-apply.png)

## Tc2r1's Notes

textAppearance is an attribute on any view that defines text. It only lets you define things 
about how to display text.

All text styles in Material Design Components can be used as textAppearance, that way any theme 
attribute defined will not be over written by material style. 

To use Material Attributes use "?attr/"

Material Attributes help create consist designs that are easy to update. 

Theme Overlays are lightweight themes for changing one section of the screen to have a different 
theme.


### Designing for Everyone, User Support!

The Accessibility Scanner is vital for making an application accessible. It scans the 
application and suggest improvements such as making touch targets larger, increasing contrast 
and adding descriptions on images. 

RTL APIs

* android:layoutDirection - sets the direction of a components layout

* android:textDirection - sets the direction of a components text

* android:textAlignment - sets the direction of a components text

* getLayoutDirectionFromLocal() - programmatically gets the local's specified direction.


### TALKBACK

Content Descriptors are descriptive labels that explain the meaning of views. This enables talk 
back to describe to the user what the images are. 

Hints are for Editable elements, they will always show in the UI. 

Live Regions are a way to tell Talk Back When stuff changes. For example: Informing the user about
an incorrect password or network error is a great way to make an application more accessible. 

We should not use hardcoded colors because this makes it hard for color blinded individuals. 
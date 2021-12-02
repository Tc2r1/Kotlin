# Android Kotlin Completed Training Applications. 

<p align="center"> <image src="_resources/android_head.png" width="200px" /></p>
 
<div align="center">This Repo is used to track a series of Android Kotlin apps I've created based on Google & Udacity trainings. In addition to extra resources to cover latest MAD features and Android associate developer certificate requirements.</div> <br>
 
 This repository includes Kotlin sample applications I've created based on latest Android guidelines available in the following references:<br>
- [Developing Android apps with Kotlin series.](https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012) <br>
- [Advanced Android apps with Kotlin series.](https://www.udacity.com/course/advanced-android-with-kotlin--ud940) <br>
- [Associate Android developer materials.](https://developers.google.com/certification/associate-android-developer) <br>
 
 I am using these apps as reference to learn more about Android latest features and to prepare for Android associate developer certificate. 
 
# Available applications

This is an overview of the applications and the development capabilities and features I've obtained that each application represents:
 
### Udacity: 
All applications under /Udacity folder:

- [**DiceRoller**](Udacity/DiceRoller/): the basic of Android layouts and actions.<br><br>
- [**Aboutme**](Udacity/AboutMe/): how to use Android data binding features.<br><br>
- [**ColorMyviews**](Udacity/ColorMyViews/): build responsive views with constraint layout.<br><br>
- [**TriviaApp**](Udacity/TriviaApp/): usage of navigation graphs, navigation drawer and fragments.<br><br>
- [**DessertPusher**](Udacity/DessertPusher/): handling acitivty/ fragment lifecycle and observers.<br><br>
- [**GuessIt**](Udacity/GuessIt/): a word guessing game to learn about application archeticture, viewModel and liveData.<br><br>
- [**SleepQualityTracker**](Udacity/TrackMySleepQuality/): room database, recyclerview, coroutines and basic unit testing.<br><br>
- [**GridLayout**](Udacity/GridLayout/): room database and grid layout.<br><br>
- [**MarsRealEstate**](Udacity/MarsRealEstate/): viewModel & liveData with retrofit, glide and moshi in Kotlin.!<br><br>
- [**OfflineCaching**](Udacity/OfflineCaching/): room database and retrofit2 with workManager using MVVM architecture.<br><br>
- [**DesignForEveryone**](Udacity/DesignForEveryone/): themes, styles, overlays, attributes, tint, accessbility, RTL and more.<br><br>

[comment]: <> (### Advanced)

[comment]: <> (All applications under /advanced folder:)

[comment]: <> (- **EggTimer**: learn how to show and custom notifications &#40;*require to generate google-services.json from firebase*&#41;.<br><br>)

[comment]: <> (- **CustomFanControl**: design and implement the functionality of custom view to control a dummy fan.<br><br>)

[comment]: <> (- **MiniPaint**: draw on custom view using a canvas and cache for better performance.<br><br>)

[comment]: <> (- **TodoTester**: Write basic tests for a todo application, and choose between instrumented/ local tests.<br><br>)

[comment]: <> (- **firebaseLogin**: Create user authentication using Firebase backend.<br><br>)

[comment]: <> (### Extras)

[comment]: <> (Projects to showcase the rest of the Android associate certificate topics, that was not fully covered in the kotlin series applications.<br>)

[comment]: <> (All applications under /extras folder:<bt>)

[comment]: <> (- **MotionDemo**: learn how to build widget animation using the motion layout.<br><br>)

[comment]: <> (- **MemoryEater**: async task and memory leaks.<br><br>)

[comment]: <> (- **GitHubPaging**: search GitHub for repositories displayed in paging list.<br><br>)

[comment]: <> (- **AppWithSettings**: Simple settings fragment with toggle switch.<br><br>)

# Android Certificate Topics

This section to show the topics of the Kotlin Android associate developer exam and related reference applications in this repository.

### Core 
Topic  | Application | Filename 
------------- | ------------- | -------------
Snackbar  | SleepQualityTracker | SleepTrackerFragment
Snackbar  | Theme | GdgListFragment
AndroidX | DiceRoller | -
Android KTX | [reference](https://developer.android.com/kotlin/ktx) | -
Android KTX (Navigation) | AndroidTrivia | MainActivity,<br>navigation_main
Android KTX (Room) | GridSleepQualityTracker | -
Android KTX (WorkManager) | OfflineCaching | RefreshDataWork,<br>OfflineCachingApplication (setupPeriodicWorker)

[comment]: <> (Toast  | EggTimer | EggTimerFragment)
[comment]: <> (Create a Notification | EggTimer | NotificationUtils,<br>EggTimerFragment &#40;createChannel&#41;,<br>AlarmReceiver [optional])


### User Interface
Topic  | Application | Filename 
------------- | ------------- | -------------
ConstraintLayout | ColorMyviews | activity_main,<br>build.gradle
RecyclerView list | SleepQualityTracker,<br>GridSleepQualityTracker | SleepNightAdapter,<br>SleepTrackerFragment,<br>fragment_sleep_tracker
Navigation drawer | AndroidTrivia | MainActivity,<br>activity_main,<br>navdrawer_menu
Start activity | GridSleepQualityTracker | SleepTrackerFragment
Share Intent | AndroidTrivia | GameWonFragment (createShareIntent)
Themes | DesignForEveryone | -
Lifecycles | DessertPusher | MainActivity
Menu | AndroidTrivia | winner_menu,<br>GameWonFragment

[comment]: <> (Custom view components | CustomFanControl | DialView)
[comment]: <> (Paging library and flow | GitHubPaging | GithubPagingSource,<br>GithubRepository,<br>SearchRepositoriesViewModel,<br>ReposAdapter)
[comment]: <> (Start activity with result | FirebaseLogin | MainFragment &#40;firebaseLauncher&#41;)
[comment]: <> (Loading state footer | GitHubPaging | ReposLoadStateViewHolder,<br>ReposLoadStateAdapter,<br>SearchRepositoriesActivity &#40;initAdapter&#41;)

### Data Management
Topic  | Application | Filename | Function
------------- | ------------- | ------------- | -------------
viewModelScope | TodoTester| TasksViewModel | completeTask,<br>clearCompletedTasks
Room database and liveview | SleepQualityTracker,<br>GridSleepQualityTracker | SleepTrackerViewModel (allNights)
Repository | OfflineCaching | VideosRepository,<br>VideoDao,<br>Network

[comment]: <> (App settings with shared preferences | AppWithSettings | SettingsFragment, MainActivity &#40;displaySwitchValue&#41;)

[comment]: <> (App settings with shared preferences | firebaseLogin | settings,<br>SettingsFragment)

### Debugging
Topic  | Reference
------------- | -------------
Debugging | https://developer.android.com/studio/debug/
Android logs | https://developer.android.com/studio/debug/am-logcat


[comment]: <> (### Testing)

[comment]: <> (Topic  | Application | Filename | Test Method)

[comment]: <> (------------- | ------------- | ------------- | -------------)

[comment]: <> (Junit basic| TodoTester | StatisticsUtilsTest | Local Test)

[comment]: <> (Hamcrest<br> &#40;English written test&#41; | TodoTester | StatisticsUtilsTest | Local Test)

[comment]: <> (Junit for liveData and viewModel<br> &#40;AndroidX test&#41; | TodoTester | TasksViewModelTest | Local Test)

[comment]: <> (Fake viewModel repository | TodoTester | TasksViewModelTestFake | Local Test)

[comment]: <> (Dependency inject test | TodoTester | DefaultTasksRepositoryTest | Local Test)

[comment]: <> (coroutines test | TodoTester | build.gradle,<br>DefaultTasksRepositoryTest | Local Test)

[comment]: <> (Fragment intigration test<br>&#40;ServiceLocator, Espresso & Mokito&#41; | TodoTester | build.gradle,<br>ServiceLocator,<br>TodoApplication,<br>TaskDetailFragmentTest | AndroidTest)

[comment]: <> (Mocks using mockito | TodoTester | TasksFragmentTest | AndroidTest)

[comment]: <> (runBlockingTest | TodoTester | TasksFragmentTest | AndroidTest)

[comment]: <> (Junit rule & coroutine dispatcher | TodoTester | MainCoroutineRule,<br>TasksViewModelTestFake | Local Test)

[comment]: <> (Room and Dao test | TodoTester | build.gradle,<br>TasksDaoTest | AndroidTest)

[comment]: <> (Room and local data source | TodoTester | build.gradle,<br>TasksLocalDataSourceTest | AndroidTest)

[comment]: <> (End to end espresso test<br>&#40;ActivityScenario used&#41; | TodoTester | TasksActivityTest | AndroidTest)

[comment]: <> (### Important)

[comment]: <> (Make sure to review the official exam guide:, for the latest updated exam topics:)

[comment]: <> (https://developers.google.com/certification/associate-android-developer/study-guide)


# Bus Scheduler App
App \#1 in Unit 5: Data Persistence

## Introduction
The Bus Scheduler app displays a list of bus stops and arrival times. Tapping a bus stop on the first screen will display a list of all arrival times for that particular stop.

The bus stops are stored in a Room database. Schedule items are represented by the `Schedule` class and queries on the data table are made by the `ScheduleDao` class. The app includes a view model to access the `ScheduleDao` and format data to be display in a list, using `Flow` to send data to a recycler view adapter.

This app is based off the [starter code](https://github.com/google-developer-training/android-basics-kotlin-bus-schedule-app/tree/starter)
for the Bus Scheduler app in Android Basics [Unit 5](https://developer.android.com/courses/android-basics-kotlin/unit-5).

## Learning Outcomes
- Use `Room` to access a SQL database.
- Create a Data Access Object (`DAO`) to define SQL statements.
- Define a `Room Entity` to map SQL table entries to Kotlin objects.
- Use `Flow` to observe and respond to databases changes asynchronously.


# DevByte App
App \#3 in Unit 5: Data Persistence

## Introduction
DevByteRepository app displays a list of DevByte videos. DevByte videos are
short videos made by the Google Android developer relations team to introduce
new developer features on Android. This app demonstrates the Repository pattern,
the recommended best practice for code separation and architecture. Using
repository pattern the data layer is abstracted from the rest of the app.
Repositories act as mediators between different data sources, such as persistent
models, web services, and caches and the rest of the app.

This app is based off the [starter code](https://github.com/google-developer-training/android-kotlin-fundamentals-starter-apps/tree/master/RepositoryPattern-Starter)
for the Repository Pattern app in Android Basics [Unit 5](https://developer.android.com/courses/android-basics-kotlin/unit-5).

## Learning Outcomes
- Implement a Repository Pattern using `Room` and other Android Architecture
  Components to cache network responses in order to improve user experience.
  The app will fetch videos and cache them when there is a network connection
  and load them from cache when there is no network available.

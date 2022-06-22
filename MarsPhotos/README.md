# Mars Photos app
App \#1 in Unit 4: Connect to the Internet

## Introduction

The Mars Photos app shows real images of Mars' surface. The images are hosted
on a RESTful web service at `android-kotlin-fun-mars-server.appspot.com`. The
app uses [Retrofit](https://square.github.io/retrofit/) with
[Moshi](https://github.com/square/moshi/) to make REST requests to the server
and deserialize the JSON response to Kotlin objects. The app fetches,
decodes, caches, and binds the images using [Coil](https://coil-kt.github.io/coil/).

The app also leverages Kotlin Coroutines for network requests,
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel),
[LiveData](https://developer.android.com/topic/libraries/architecture/livedata), and
[Data Binding](https://developer.android.com/topic/libraries/data-binding/) with binding
adapters.

This app is based off the [starter code](https://github.com/google-developer-training/android-basics-kotlin-mars-photos-app/tree/starter)
for the Mars Photos app in Android Basics [Unit 4](https://developer.android.com/courses/android-basics-kotlin/unit-4).

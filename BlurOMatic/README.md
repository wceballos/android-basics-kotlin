# Blur-O-Matic App
App \#1 in Unit 6: Schedule Tasks With WorkManager

## Introduction
The Blur-O-Matic app allows the user to blur an image leveraging WorkManager
to do the work in the background. There are three workers: one for cleaning up
temporary files, one to blur the image, and one to save the final blurred
image. The work is scheduled in a unique work chain, allowing the user to
cancel the work and requiring constraints, such as the device being charging
and the storage not low.

This app is based on the [starter code](https://codelabs.developers.google.com/codelabs/android-workmanager)
for the Blur-O-Matic app in Android basics [Unit 6](https://developer.android.com/courses/android-basics-kotlin/unit-6).

## Learning Outcomes
- Using the [WorkManager library](https://developer.android.com/topic/libraries/architecture/workmanager/)
  from android Jetpack.
- Creating `Work`, work requests, and work constraints to schedule work
  with `WorkManager`.
- Chaining work in a unique work chain.
- Passing the `Data` result from one work to another.
- Monitoring Workers using App Inspection in Android Studio.
- Tracking and displaying the progress of workers.

## License

Copyright 2018 Google, Inc.

All image and audio files (including *.png, *.jpg, *.svg, *.mp3, *.wav
and *.ogg) are licensed under the CC BY 4.0 license. All other files are
licensed under the Apache 2 license.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the LICENSE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.

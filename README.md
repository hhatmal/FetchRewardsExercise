# FetchRewardsExercise
Offline-first application that fetches and displays items on the screen.

# Architecture
MVVM/MVI with repository
App is split between presentation, domain, and data layers

# Offline-first
App stores data that is fetched remotely into the local database (Room). App will work 
when internet is not available.

# Libraries
- Jetpack Compose for UI
- Koin for dependency injection
- Retrofit for networking
- Room for local database
- JUnit/Mockito for unit tests

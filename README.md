## 📒 Table of Contents
- [📒 Table of Contents](#-table-of-contents)
- [📍 Overview](#-overview)
- [🚀 Screenshots](#-Screenshots)
-  [🧩 Modules](#-modules)
- [⚙️ Gradle Dependencies](#-features)
- [📂 Project Structure](#project-structure)
- [🗺 Firebase Console ](#-getting-started)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)
- [👏 Acknowledgments](#-acknowledgments)

---

## 📍 Overview

Welcome to the Bank Branch Locator app! Easily find and filter bank branches, view detailed branch information, and get directions to your chosen branch. Simplify your search and plan your visit with ease.
![bankstory](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/9049d1ed-240a-4e1a-be06-f4793ad0b104)

## 🚀Screenshots






| Splash Screen           |  Home Screen | Home Loading |  Home Search  |
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
 ![splash](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/98c0ee45-06f3-4b41-ad36-f4fc382f1829) |                                      ![home](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/ffda1951-f8c0-4219-a9ac-0b6d40bcda73) |                                                                                [homeloading](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/565fbe49-54f1-4647-a1df-85dc4dc76b01) |                                                                          ![homesearch](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/4de09dbc-3aab-4dc3-ab45-35c5c9dfe83c) |

 | Detail Screen          |  Detail navigation | Home English | Home Turkish |
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
![detail](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/71771fc2-0cbe-4098-b604-1b697cee1064) |![detailnavigation](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/d1124e9c-1684-49f6-871a-8e3066356fdd) | ![homeeng](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/3d0748f5-1d4f-451e-a6e4-6f42046bccc6) |![hometr](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/1da0cd41-ec4d-4b3a-b194-76e620dda987) |

**All Screen Of The Bank Application**

---

---



## 🧩 Modules
![clean_art](https://github.com/huseyinozkoc/BitcoinTicker/assets/48124105/b17f3b7b-510d-4900-a19e-02110ec1ef69)

<details closed><summary>Common</summary>
  
| File                | Summary                                                                                                                                                                      |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Constants.kt        | Contains constant values used throughout the application, such as API endpoints, keys, and other configuration settings.                                                    |
| NetworkCallResource.kt | Defines a sealed class for representing the result of a network call, including success, error, and loading states.                                                        |
</details>

<details closed><summary>Data</summary>

| File           | Summary                                                                                                                                                               |
| -------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Models.kt      | Defines the data models or entities that represent structured data within the application. These models may correspond to database tables, API responses, or other data sources.                                                                                                                                                   |
| Repository.kt  | Implementation of data repository classes responsible for handling data access and manipulation. This may include data retrieval from local databases (e.g., Room) or remote APIs (e.g., Retrofit).                                                                                                                                                   |
| Source          | This directory contains submodules for handling data sources, such as local and remote sources. Local sources may include database-related classes (e.g., Room database), while remote sources may include API-related classes (e.g., Retrofit).                                                                                                                                                   |
</details>

<details closed><summary>Dependency Injection</summary>

| File                | Summary                                                                                                                                                                      |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| FirebaseModule.kt   | Dependency injection module for integrating Firebase services into the application. This module may provide Firebase-related dependencies like Firebase authentication, Firestore, etc.                                                    |
| RetrofitModule.kt   | Dependency injection module for configuring Retrofit and providing API-related dependencies.                                                |
| RepositoryModule.kt | Dependency injection module for providing data repository dependencies, such as data sources and mappers.                                                                                                                                                                                                                   |
</details>


<details closed><summary>Domain</summary>

| File               | Summary                                                                                                                                                               |
| ------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| UseCases.kt       | Defines use cases that encapsulate the application's business logic and represent user interactions.                                                                                                                                                                                                                   |
| DataSourceInterfaces.kt | Interfaces that define the contract for data sources, allowing for abstraction and separation between data retrieval and domain logic.                                                                                                                                                   |
| RepositoryInterfaces.kt  | Interfaces that define the contract for repositories, providing a clear separation between the domain layer and the data layer.                                                                                                                                                   |
</details>

<details closed><summary>Presentation</summary>

| File       | Summary                                                                                                                                                               |
| ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Views      | This directory contains the user interface components (e.g., activities, fragments, views) responsible for presenting data and interacting with the user.                                                                                                                                                                                                                   |
| ViewModels | Contains ViewModel classes that manage the presentation logic and data binding between the domain and UI layers.                                                                                                                                                                                                                   |
</details>

<details closed><summary>Design System</summary>

| File       | Summary                                                                                                                                                               |
| ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Views      | Include common design components for all project.                                                                                                                                                                                                                  |

</details>


---

## ⚙️ Gradle Dependencies
![gradle](https://github.com/huseyinozkoc/BitcoinTicker/assets/48124105/dbf4a339-1c0c-43ff-b1bd-bf05cd60ba8c)

- MVVM with Clean Architecture
 - Coroutines & Flow
 - Compose Navigation
 - Hilt for Dependency Injection
 - Retrofit
 - Coil


| Versions          |  Libraries | Plugins |  Home Screen  |
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
  
![lib1](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/9dd87c50-92d3-4b15-a2bd-f9ff6816f4d5) | ![lib2](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/d0bd8d91-634b-43cc-94b9-40600e83b279)
   | ![lib3](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/d3ae3660-d2d0-45a9-8967-aafd8ea378b9) | 



**All Gradle Of The Bank Application**

---

 
---



---
## 📂 Project Structure

![project structure](https://github.com/huseyinozkoc/EnquraAndroidDeveloperChallenge/assets/48124105/ec872abb-36e5-4c60-93b0-7b5728b18372)

---


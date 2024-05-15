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

---



## 🧩 Modules
![clean_art](https://github.com/huseyinozkoc/BitcoinTicker/assets/48124105/b17f3b7b-510d-4900-a19e-02110ec1ef69)

<details closed><summary>Common</summary>
  
| File                | Summary                                                                                                                                                                      |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Constants.kt        | Contains constant values used throughout the application, such as API endpoints, keys, and other configuration settings.                                                    |                           |
| NetworkCallResource.kt | Defines a sealed class for representing the result of a network call, including success, error, and loading states.                                                        |
</details>

<details closed><summary>Data</summary>

| File           | Summary                                                                                                                                                               |
| -------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |                                                                                                                                                                                                             |
| Models.kt      | Defines the data models or entities that represent structured data within the application. These models may correspond to database tables, API responses, or other data sources.                                                                                                                                                   |
| Repository.kt  | Implementation of data repository classes responsible for handling data access and manipulation. This may include data retrieval from local databases (e.g., Room) or remote APIs (e.g., Retrofit).                                                                                                                                                   |
| Source          | This directory contains submodules for handling data sources, such as local and remote sources. Local sources may include database-related classes (e.g., Room database), while remote sources may include API-related classes (e.g., Retrofit).                                                                                                                                                   |
</details>

<details closed><summary>Dependency Injection</summary>

| File                | Summary                                                                                                                                                                      |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| FirebaseModule.kt   | Dependency injection module for integrating Firebase services into the application. This module may provide Firebase-related dependencies like Firebase authentication, Firestore, etc.                                                       |
| RetrofitModule.kt   | Dependency injection module for configuring Retrofit and providing API-related dependencies.                                                |
| RepositoryModule.kt | Dependency injection module for providing data repository dependencies, such as data sources and mappers.                                                                                                                                                                                                                   |

<details closed><summary>Domain</summary>

| File               | Summary                                                                                                                                                               |
| ------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| UseCases.kt       | Defines use cases that encapsulate the application's business logic and represent user interactions.                                                                                                                                                                                                                   |
| DataSourceInterfaces.kt | Interfaces that define the contract for data sources, allowing for abstraction and separation between data retrieval and domain logic.                                                                                                                                                   |
| RepositoryInterfaces.kt  | Interfaces that define the contract for repositories, providing a clear separation between the domain layer and the data layer.                                                                                                                                                   |                                                                                                                                                                                                             |
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
| Design System      | Include common design components for all project.                                                                                                                                                                                                                   |
</details>

---

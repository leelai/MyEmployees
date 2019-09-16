# MyEmployees
The MyEmployees app is parsing json data from http://dummy.restapiexample.com/api/v1/employees

# Demo
![add event](/preview/demo.gif)

# Dependencies
*  Kotlin stdlib
*  kotlin-android plugin

# Implementing the app
* This app is composed of only one activity; display all employees from http://dummy.restapiexample.com/api/v1/employees.
* The activity implements [Model-View-Presenter](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) (MVP) architecture

![mvp](/preview/mvp.png)

# Third party library
* [retrofit2](https://square.github.io/retrofit/)
* [converter-gson](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)
* [gson](https://github.com/google/gson)

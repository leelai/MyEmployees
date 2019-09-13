package com.example.myapplication.data.source

interface EmployeeDataSource {

    interface LoadEmployeesCallback {

        fun onEmployeesLoaded(employees: List<Employee>)

        fun onDataNotAvailable()
    }

    fun getEmployees(callback: LoadEmployeesCallback)
}
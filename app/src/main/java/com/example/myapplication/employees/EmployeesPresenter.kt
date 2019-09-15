package com.example.myapplication.employees

import com.example.myapplication.data.source.Employee
import com.example.myapplication.data.source.EmployeeDataSource
import com.example.myapplication.data.source.EmployeeRepository

class EmployeesPresenter(private val employeesRepository: EmployeeRepository, val employeesView: EmployeesContract.View)
    : EmployeesContract.Presenter {

    init {
        employeesView.presenter = this
    }

    override fun loadEmployees() {
        employeesRepository.getEmployees(object : EmployeeDataSource.LoadEmployeesCallback {
            override fun onEmployeesLoaded(employees: List<Employee>) {
                employeesView.showEmployees(employees)
            }

            override fun onDataNotAvailable() {
                employeesView.showNoEmployees()
            }
        })
    }

    override fun start() {
        loadEmployees()
    }


}
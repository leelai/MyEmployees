package com.example.myapplication.employees

import com.example.myapplication.BasePresenter
import com.example.myapplication.BaseView
import com.example.myapplication.data.source.Employee

/**
 * This specifies the contract between the view and the presenter.
 */
interface EmployeesContract {

    interface View : BaseView<Presenter> {

        fun setLoadingIndicator(active: Boolean)

        fun showEmployees(employees: List<Employee>)

        fun showNoEmployees()
    }

    interface Presenter : BasePresenter {

        fun loadEmployees()
    }
}

package com.example.myapplication.data.source

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepository private constructor(): EmployeeDataSource {

    private val service = EmployeeApi.create()

    override fun getEmployees(callback: EmployeeDataSource.LoadEmployeesCallback) {

        service.getEmployees().enqueue(object : Callback<List<Employee>> {
            override fun onResponse(
                call: Call<List<Employee>>,
                response: Response<List<Employee>>
            ) {
                callback.onEmployeesLoaded(response.body()!!)
            }

            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                callback.onDataNotAvailable()
            }
        })
    }

    companion object {

        private var INSTANCE: EmployeeRepository? = null

        @JvmStatic fun getInstance(): EmployeeRepository {
            return INSTANCE ?: EmployeeRepository()
                .apply { INSTANCE = this }
        }

        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}
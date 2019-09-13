package com.example.myapplication.data.source

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface EmployeeApi {

    // factory methods
    companion object {
        private const val baseUrl = "HTTP://dummy.restapiexample.com"

        fun create(): EmployeeApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(EmployeeApi::class.java)
        }
    }

    @GET("/api/v1/employees")
    fun getEmployees(): Call<List<Employee>>
}
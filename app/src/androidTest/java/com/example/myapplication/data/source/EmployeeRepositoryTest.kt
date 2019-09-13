package com.example.myapplication.data.source

import org.hamcrest.Matchers.greaterThan
import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class EmployeeRepositoryTest {

    @Test
    fun getEmployees() {

        val latch = CountDownLatch(1)
        var employeeRepository = EmployeeRepository.getInstance()
        employeeRepository.getEmployees(object : EmployeeDataSource.LoadEmployeesCallback {
            override fun onEmployeesLoaded(employees: List<Employee>) {
                assertThat(employees.size, greaterThan(0))
                latch.countDown()
            }

            override fun onDataNotAvailable() {
            }
        })

        latch.await(2000, TimeUnit.MILLISECONDS);
        assertEquals(0, latch.count)
    }
}
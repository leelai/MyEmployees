package com.example.myapplication.employees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.data.source.EmployeeRepository
import com.example.myapplication.utils.replaceFragmentInActivity

class EmployeesActivity : AppCompatActivity() {

    private lateinit var employeesPresenter: EmployeesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val employeesFragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
                as EmployeesFragment? ?: EmployeesFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.contentFrame)
        }

        // Create the presenter
        employeesPresenter = EmployeesPresenter(EmployeeRepository.getInstance(),
            employeesFragment)
    }
}

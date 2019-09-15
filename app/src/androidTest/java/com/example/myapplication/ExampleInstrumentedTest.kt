package com.example.myapplication

import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.data.source.EmployeeApi
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.greaterThan

import org.junit.Test

import org.junit.Assert.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }

    @Test
    fun employeeApi() {
        val service = EmployeeApi.create()
        val callback = service.getEmployees().execute()
        assertThat(callback.code(), `is`(200))
        assertNotNull(callback.body())
        assertThat(callback.body()!!.size,  `greaterThan`(0))
    }
}

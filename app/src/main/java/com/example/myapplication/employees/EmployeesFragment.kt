package com.example.myapplication.employees

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.data.source.Employee
import androidx.recyclerview.widget.DividerItemDecoration

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [EmployeesFragment.OnListFragmentInteractionListener] interface.
 */
class EmployeesFragment : Fragment(), EmployeesContract.View {

    override lateinit var presenter: EmployeesContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employees_list, container, false)
    }

    override fun setLoadingIndicator(active: Boolean) {

    }

    override fun showEmployees(employees: List<Employee>) {
        // Set the adapter
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = EmployeesRecyclerViewAdapter(employees)

            val dividerItemDecoration = DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
            addItemDecoration(dividerItemDecoration)
        }
    }

    override fun showNoEmployees() {

    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance() = EmployeesFragment()
    }
}

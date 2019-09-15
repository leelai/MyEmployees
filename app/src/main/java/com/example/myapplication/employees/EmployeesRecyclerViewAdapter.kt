package com.example.myapplication.employees

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.data.source.Employee

import kotlinx.android.synthetic.main.fragment_employees.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class EmployeesRecyclerViewAdapter(
    private val mEmployees: List<Employee>
) : RecyclerView.Adapter<EmployeesRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_employees, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mEmployees[position]
        holder.mIdView.text = item.id
        holder.mNameView.text = item.employee_name
        holder.mSalaryView.text = item.employee_salary
        holder.mAgeView.text = item.employee_age
        holder.mImage.text = item.profile_image

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mEmployees.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.user_id
        val mNameView: TextView = mView.name
        val mSalaryView: TextView = mView.salary
        val mAgeView: TextView = mView.age
        val mImage: TextView = mView.profile_image

        override fun toString(): String {
            return super.toString() + " '" + mNameView.text + "'"
        }
    }
}

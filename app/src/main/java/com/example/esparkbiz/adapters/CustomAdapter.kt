package com.example.esparkbiz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esparkbiz.R
import com.example.esparkbiz.models.Employee

class CustomAdapter(private val employeeList: ArrayList<Employee>) :
    RecyclerView.Adapter<CustomAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.employee_image);
        var name: TextView = view.findViewById(R.id.employee_name);
        var designation: TextView = view.findViewById(R.id.employee_designation);
        var address: TextView = view.findViewById(R.id.employee_address);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_employee_card, parent, false
        );
        return EmployeeViewHolder(view);
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        var item = employeeList[position];
        holder.image.setImageResource(item.image);
        holder.name.text = item.name;
        holder.designation.text = item.designation;
        holder.address.text = item.address;

    }

    override fun getItemCount(): Int {
        return employeeList.size;
    }
}
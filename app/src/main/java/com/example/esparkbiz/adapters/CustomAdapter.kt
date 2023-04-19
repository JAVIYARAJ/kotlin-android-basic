package com.example.esparkbiz.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esparkbiz.R
import com.example.esparkbiz.database.DatabaseHelper
import com.example.esparkbiz.layouts.EditDataScreen
import com.example.esparkbiz.models.Employee
import com.example.esparkbiz.utils.Util

class CustomAdapter(private val employeeList: ArrayList<Employee>, var context: Context) :
    RecyclerView.Adapter<CustomAdapter.EmployeeViewHolder>() {
    var databaseHelper: DatabaseHelper = DatabaseHelper(context);

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var email: TextView = view.findViewById(R.id.employee_email);
        var name: TextView = view.findViewById(R.id.employee_name);
        var city: TextView = view.findViewById(R.id.employee_city);
        var address: TextView = view.findViewById(R.id.employee_address);
        var editBtn: ImageView = view.findViewById(R.id.edit_info_btn);
        var deleteBtn: ImageView = view.findViewById(R.id.delete_info_btn);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_employee_card, parent, false
        );
        return EmployeeViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        var item = employeeList[position];
        holder.name.text = item.name;
        holder.address.text = item.address;
        holder.city.text = item.city;
        holder.email.text = item.email;

        var name= item.name;
        var email= item.email;
        var city= item.city;
        var address= item.address;

        holder.editBtn.setOnClickListener {

            if (name.isNotEmpty() && email.isNotEmpty() && city
                    .isNotEmpty() && address.isNotEmpty()
            ) {

                var intent=Intent(context,EditDataScreen::class.java);
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("city",city);
                intent.putExtra("address",address);
                context.startActivity(intent);
            } else {
                Util.displayToast("Please enter all values", context);
            }

        }

        holder.deleteBtn.setOnClickListener {
            var response = databaseHelper.deleteData(item.id.toString());
            Util.displayToast("Deleted Successfully.", context);
            notifyDataSetChanged();
        }
    }

    override fun getItemCount(): Int {
        return employeeList.size;
    }
}
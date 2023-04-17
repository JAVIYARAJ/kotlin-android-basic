package com.example.esparkbiz.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.esparkbiz.models.Employee;
import com.example.esparkbiz.R
import com.example.esparkbiz.adapters.CustomAdapter

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)


        var recyclerView = findViewById<RecyclerView>(R.id.employee_recyclerview);
        recyclerView.layoutManager = LinearLayoutManager(this)
        var employeeList = ArrayList<Employee>();

        employeeList.add(Employee(R.drawable.ic_user_pick, "raj", "Android Developer", "Junagadh"));
        employeeList.add(Employee(R.drawable.ic_user_pick, "khushi", "React Developer", "Keshod"));
        employeeList.add(Employee(R.drawable.ic_user_pick, "meet", "Node Developer", "Surat"));
        employeeList.add(
            Employee(
                R.drawable.ic_user_pick, "mansi", "Blockchain Developer", "Rajkot"
            )
        );
        employeeList.add(
            Employee(
                R.drawable.ic_user_pick, "meet", "Vue Developer", "Surat"
            )
        );

        Log.d("Practice", employeeList.toString());

        var adapter = CustomAdapter(employeeList);
        recyclerView.adapter = adapter;

    }
}
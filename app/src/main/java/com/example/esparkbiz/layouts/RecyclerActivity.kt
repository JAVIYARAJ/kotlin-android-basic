package com.example.esparkbiz.layouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.esparkbiz.models.Employee;
import com.example.esparkbiz.R
import com.example.esparkbiz.adapters.CustomAdapter
import com.example.esparkbiz.database.DatabaseHelper

class RecyclerActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)


        var recyclerView = findViewById<RecyclerView>(R.id.employee_recyclerview);
        recyclerView.layoutManager = LinearLayoutManager(this)
        var employeeList = ArrayList<Employee>();

        var sharedPreferences = applicationContext.getSharedPreferences("user_info", MODE_PRIVATE);
        var data = sharedPreferences.getString("name", "test");

        var databaseHelper: DatabaseHelper = DatabaseHelper(applicationContext);

        var list = arrayListOf<Employee>();
        var fetchedData = databaseHelper.displayData();

        if (fetchedData.moveToFirst()) {
            do {
                var id = fetchedData.getInt(fetchedData.getColumnIndex("ID"))
                var name = fetchedData.getString(fetchedData.getColumnIndex("NAME"))
                var email = fetchedData.getString(fetchedData.getColumnIndex("EMAIL"))
                var city = fetchedData.getString(fetchedData.getColumnIndex("CITY"))
                var address = fetchedData.getString(fetchedData.getColumnIndex("ADDRESS"))
                var employee = Employee(id, name, email, city, address);
                list.add(employee);
            } while (fetchedData.moveToNext());
        }



        var adapter = CustomAdapter(list);
        recyclerView.adapter = adapter;

    }
}
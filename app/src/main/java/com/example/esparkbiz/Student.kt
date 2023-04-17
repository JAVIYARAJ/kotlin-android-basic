package com.example.esparkbiz

import android.util.Log
import java.util.Objects

data class Student(
    var name: String, var city: String
);

class Employee {

    lateinit var employeeName: String;
    lateinit var employeeCity: String;

    fun displayReport() {
        Log.d("Practice","Employee name ${employeeName} and ${employeeCity}");
    }

    companion object {
        fun displayEmployeeReport() {
            println("display employee report");
        }
    }
}



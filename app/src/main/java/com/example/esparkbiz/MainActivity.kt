package com.example.esparkbiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var names = arrayOf(1, 2, 3);

        names.forEach {
            Log.d("practice", it.toString());
        }

        var name = hashMapOf<String, String>();

        name.put("name", "raj");
        name.put("email", "raj@gmail.com");
        name.put("city", "junagadh");

        for (i in name.iterator()) {
            Log.d("practice", "${i.key} ${i.value}");
        }

        //Log.d("practice", name.keys.toString());

        var city = mutableSetOf<String>("junagadh", "rajkot", "surat", "keshod", "rajkot");
        Log.d("practice", city.toString());

        //anonymous class
        var marks = object : student_marks {
            override fun displayReport() {
                super.displayReport()
                println("other report");
            }
        }.displayReport();

        //companion object
        Employee.displayEmployeeReport();

        //filter
        var numbers = arrayOf(1, 22, 32, 14, 5);
        var filterResult = numbers.filter { it ->
            it > 10;
        }
        Log.d("practice", filterResult.toString());

        //map
        var mappedResult = numbers.map { it ->
            it * 10;
        }
        Log.d("practice", mappedResult.toString());

        //filter and map
        var result = numbers.filter { it ->
            it > 10;
        }.map { it ->
            it * 10;
        }
        Log.d("practice", result.toString());

        //predicated methods
        var anyResult = numbers.any { it ->
            it > 100;
        }
        var allResult = numbers.any { it ->
            it > 100;
        }
        var countResult = numbers.any { it ->
            it > 100;
        }
        var findResult = numbers.any { it ->
            it > 100;
        }

        Log.d("practice", "any method resutl ${anyResult.toString()}");
        Log.d("practice", "all method resutl ${allResult.toString()}");
        Log.d("practice", "count method resutl ${countResult.toString()}");
        Log.d("practice", "find method resutl ${findResult.toString()}");

        //with keyword in kotlin
        var eReport1 = Employee();
        with(eReport1) {
            this.employeeName = "raj";
            this.employeeCity = "Junagadh";
        }

        Log.d("Practice", "display using with");
        eReport1.displayReport();

        //apply keyword in kotlin-> in this we not need to write this keyword also we can call is method directly.
        Log.d("Practice", "display using apply");
        var eReport2 = Employee().apply {
            employeeName = "raj";
            employeeCity = "junagadh";
        }.displayReport();

        //run keyword in kotlin-> in this we not need to write this keyword also we can also return something.
        var runResult=eReport1.run {
            employeeName="raj";
            employeeCity="junagadh"
            "success"
        }

        Log.d("Practice", "display using run");
        eReport1.displayReport();
        Log.d("Practice", "${runResult}");


        //also keyword in kotlin
        Log.d("Practice", "display using apply for CRUD");

        var cityList= java.util.ArrayList<String>();

        cityList.also {
            it.add("keshod");
            it.add("surat");
            it.add("junagadh");
            it.remove("keshod");
            Log.d("Practice", "${it.toString()}");
        }


        //below code use for practice resource concept.

        //get city array from resource
        var cities=resources.getStringArray(R.array.city_dropdown);
        cities.forEach {
            value->Log.d("Practice", "${value}");
        }

        //get color from resource and set into container
        var mainLayout:RelativeLayout=findViewById(R.id.main_layout);
        mainLayout.setBackgroundColor(resources.getColor(R.color.card_color));

        //get bool value from resource
        var isVisibleCard=resources.getBoolean(R.bool.card_visibility);
        Log.d("Practice", "${isVisibleCard.toString()}");


        //get any type of array
        var icons=resources.obtainTypedArray(R.array.icons);
        var i1= icons.getDrawable(0);
        mainLayout.background=i1;

    }
}
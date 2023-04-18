package com.example.esparkbiz.tasks

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.get
import com.example.esparkbiz.R
import com.example.esparkbiz.utils.Util
import com.google.android.material.textfield.TextInputEditText

class Task1RegisterScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1_register_screen)

        var fname = findViewById<TextInputEditText>(R.id.user_fname);
        var lname = findViewById<TextInputEditText>(R.id.user_lname);
        var email = findViewById<TextInputEditText>(R.id.user_email);
        var gender = findViewById<RadioGroup>(R.id.user_gender);
        var hobbyLayout = findViewById<LinearLayoutCompat>(R.id.hobbyLayout);
        var cityDropdown = findViewById<AppCompatSpinner>(R.id.user_city);


        //create array adapter from resource
        var arrayAdapter = ArrayAdapter.createFromResource(
            applicationContext, R.array.cities,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item
        );

        //bind adapter with spinner
        cityDropdown.adapter = arrayAdapter;

        var displayInfoBtn = findViewById<AppCompatButton>(R.id.displayInfo);


        displayInfoBtn.setOnClickListener {

            var hobbyList = mutableListOf<String>();


            //get checkbox count using its parent (here parent is linear layout)
            var checkBoxCount = hobbyLayout.childCount;


            for (i in 0 until checkBoxCount) {

                var isChecked = findViewById<CheckBox>(hobbyLayout[i].id).isChecked;

                if (isChecked) {
                    hobbyList.add(findViewById<CheckBox>(hobbyLayout[i].id).text.toString());
                }
            }

            var intent = Intent(this@Task1RegisterScreen, Task1DisplayDataScreen::class.java);

            intent.putExtra("name", "${fname.text} ${lname.text}");
            intent.putExtra("emailAddress", email.text.toString());
            intent.putExtra("city",cityDropdown.selectedItem.toString());
            intent.putExtra(
                "gender",
                (findViewById<RadioButton>(gender.checkedRadioButtonId).text).toString()
            );
            intent.putExtra("hobby", hobbyList.toString());
            startActivity(intent);


        }


    }

    override fun onStart() {
        Util.displayToast("Register Activity started", applicationContext);
        super.onStart()
    }

    override fun onStop() {
        Util.displayToast("Register Activity stopped", applicationContext);
        super.onStop()
    }

    override fun onDestroy() {
        Util.displayToast("Register Activity destroyed", applicationContext);
        super.onDestroy()
    }

    override fun onResume() {
        Util.displayToast("Register Activity resume", applicationContext);
        super.onResume()
    }


}
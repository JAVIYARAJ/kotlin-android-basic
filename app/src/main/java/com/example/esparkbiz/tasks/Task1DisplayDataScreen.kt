package com.example.esparkbiz.tasks

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.esparkbiz.R
import com.example.esparkbiz.utils.Util
import kotlin.reflect.typeOf

class Task1DisplayDataScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1_display_data_screen)

        var fullnameText = findViewById<TextView>(R.id.student_name);
        var emailText = findViewById<TextView>(R.id.student_email);
        var genderText = findViewById<TextView>(R.id.student_gender);
        var hobbyText = findViewById<TextView>(R.id.student_hobby);
        var cityText = findViewById<TextView>(R.id.student_city);

        var intent = intent;
        fullnameText.text = intent.getStringExtra("name");
        emailText.text = intent.getStringExtra("emailAddress");
        genderText.text = intent.getStringExtra("gender");
        cityText.text=intent.getStringExtra("city");
        hobbyText.text = (intent.getStringExtra("hobby")?.replace("[", ""))?.replace("]", "") ?: "";

    }

    override fun onStart() {
        Util.displayToast("Display Activity started",applicationContext);
        super.onStart()
    }

    override fun onStop() {
        Util.displayToast("Display Activity stopped",applicationContext);
        super.onStop()
    }

    override fun onDestroy() {
        Util.displayToast("Display Activity destroyed",applicationContext);
        super.onDestroy()
    }

    override fun onResume() {
        Util.displayToast("Display Activity resume",applicationContext);
        super.onResume()
    }
}
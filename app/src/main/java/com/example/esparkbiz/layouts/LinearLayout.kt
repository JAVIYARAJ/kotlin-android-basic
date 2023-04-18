package com.example.esparkbiz.layouts

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.esparkbiz.R
import com.example.esparkbiz.database.DatabaseHelper
import com.example.esparkbiz.utils.Util
import com.google.android.material.textfield.TextInputEditText


class LinearLayout : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)


        var username = findViewById<TextInputEditText>(R.id.user_name);
        var email = findViewById<TextInputEditText>(R.id.user_email);
        var city = findViewById<TextInputEditText>(R.id.user_city);
        var address = findViewById<TextInputEditText>(R.id.user_address);
        var image = R.drawable.ic_logo;

        var registerBtn = findViewById<AppCompatButton>(R.id.registerBtn);

        registerBtn.setOnClickListener {

            var databaseHelper: DatabaseHelper = DatabaseHelper(applicationContext);

            if (username.text.toString()
                    .isNotEmpty() && email.text.toString().isNotEmpty() && city.text.toString()
                    .isNotEmpty() && address.text.toString().isNotEmpty()
            ) {
                databaseHelper.insertData(
                    username.text.toString(),
                    email.text.toString(),
                    city.text.toString(),
                    address.text.toString()
                );
                Util.displayToast("Register Successfully.", applicationContext);
            } else {
                Util.displayToast("Please enter all values", applicationContext);
            }

        };


    }

}
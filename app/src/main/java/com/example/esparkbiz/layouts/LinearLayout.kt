package com.example.esparkbiz.layouts

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import android.text.Editable
import android.util.Log
import android.widget.CheckBox
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
        var rememberCheckBox = findViewById<CheckBox>(R.id.rememberMeCheckbox);

        var sharedPreferences = applicationContext.getSharedPreferences("user_info", MODE_PRIVATE);
        var nameText: String? = sharedPreferences.getString("name", null);
        var emailText: String? = sharedPreferences.getString("email", null);
        var cityText: String? = sharedPreferences.getString("city", null);
        var addressText: String? = sharedPreferences.getString("address", null);
        var isRemember: String? = sharedPreferences.getString("isRemember", null);

        if (nameText != null && emailText != null && cityText != null && addressText != null) {
            username.setText(nameText);
            email.setText(emailText);
            city.setText(cityText);
            address.setText(addressText);
            rememberCheckBox.isChecked = isRemember.toBoolean();
        }

        var registerBtn = findViewById<AppCompatButton>(R.id.registerBtn);

        registerBtn.setOnClickListener {

            var isRememberChecked = rememberCheckBox.isChecked;
            if (isRememberChecked) {
                var data = mutableMapOf<String, Any>();
                with(data) {
                    this["name"] = username.text.toString();
                    this["email"] = email.text.toString();
                    this["city"] = city.text.toString();
                    this["address"] = address.text.toString();
                    this["isRemember"] = true;
                }
                Util.saveDataIntoSharedPreference(data, applicationContext, "user_info");
            } else {
                Util.clearSharedPreference("user_info", applicationContext);
            }

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
            username.setText("");
            email.setText("");
            city.setText("");
            address.setText("");
        };


    }

}
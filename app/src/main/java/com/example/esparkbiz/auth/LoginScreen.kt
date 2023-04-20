package com.example.esparkbiz.auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.esparkbiz.R
import com.example.esparkbiz.database.UserDatabaseHelper
import com.example.esparkbiz.utils.Util
import com.google.android.material.textfield.TextInputEditText

class LoginScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        var loginBtn: AppCompatButton = findViewById(R.id.userLoginBtn);

        var email = findViewById<TextInputEditText>(R.id.user_email_login);
        var password = findViewById<TextInputEditText>(R.id.user_password_login);

        var rememberCheckBox = findViewById<CheckBox>(R.id.authRememberMeCheckbox);

        var sharedPreferences =
            applicationContext.getSharedPreferences("user_auth_info", MODE_PRIVATE);

        var emailText: String? = sharedPreferences.getString("email", null);
        var passwordText: String? = sharedPreferences.getString("password", null);
        var isRemember: String? = sharedPreferences.getString("isRemember", "true");

        if (emailText != null && passwordText != null) {

            email.setText(emailText);
            password.setText(passwordText);

            rememberCheckBox.isChecked = isRemember.toBoolean();
        }

        loginBtn.setOnClickListener {
            if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                var isRememberChecked = rememberCheckBox.isChecked;

                var result = UserDatabaseHelper(applicationContext).getUserInfo(
                    email.text.toString(),
                    password.text.toString()
                );

                if (result == 1) {
                    if (isRememberChecked) {
                        var data = mutableMapOf<String, Any>();
                        with(data) {
                            this["email"] = email.text.toString();
                            this["password"] = password.text.toString();
                            this["isRemember"] = true;
                        }
                        Util.saveDataIntoSharedPreference(data, applicationContext, "user_auth_info");
                        var intent = Intent(applicationContext, HomeScreen::class.java);
                        intent.putExtra("email", email.text.toString());
                        startActivity(intent);
                    } else {
                        var intent = Intent(applicationContext, HomeScreen::class.java);
                        intent.putExtra("email", email.text.toString());
                        startActivity(intent);
                        Util.clearSharedPreference("user_auth_info", applicationContext);
                    }
                }else{
                    Util.displayToast("User Not Exists", applicationContext);
                }


            } else {
                Util.displayToast("please enter all data", applicationContext);
            }
        }


    }

}
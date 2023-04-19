package com.example.esparkbiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.esparkbiz.auth.LoginScreen
import com.example.esparkbiz.database.UserDatabaseHelper
import com.example.esparkbiz.utils.Util
import com.google.android.material.textfield.TextInputEditText

class RegisterScreen : AppCompatActivity() {
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        var username = findViewById<TextInputEditText>(R.id.user_reg_name);
        var email = findViewById<TextInputEditText>(R.id.user_reg_email);
        var password = findViewById<TextInputEditText>(R.id.user_reg_password);
        var cPassword = findViewById<TextInputEditText>(R.id.user_reg_cPassword);
        var registerBtn = findViewById<AppCompatButton>(R.id.userRegisterBtn);
        var loginBtn = findViewById<TextView>(R.id.moveLogin);

        loginBtn.setOnClickListener {
            var intent=Intent(applicationContext, LoginScreen::class.java);
            startActivity(intent);
        }

       registerBtn.setOnClickListener{
           var databaseHelper: UserDatabaseHelper = UserDatabaseHelper(applicationContext);

           if (username.text.toString()
                   .isNotEmpty() && email.text.toString().isNotEmpty() && password.text.toString()
                   .isNotEmpty()
           ) {
              if(password.text.toString() == cPassword.text.toString()){
                  databaseHelper.insertData(
                      username.text.toString(),
                      email.text.toString(),
                      password.text.toString(),
                  );
                  Util.displayToast("Register Successfully.", applicationContext);
              }else{
                  Util.displayToast("Password Not Match", applicationContext);

              }
           } else {
               Util.displayToast("Please enter all values", applicationContext);
           }
       }

    }
}
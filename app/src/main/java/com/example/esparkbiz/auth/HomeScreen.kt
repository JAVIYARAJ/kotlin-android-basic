package com.example.esparkbiz.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.esparkbiz.R

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        var logoutBtn=findViewById<AppCompatButton>(R.id.userLogoutBtn);
        var user=findViewById<TextView>(R.id.userEmail);


        var intent=intent;
        if(intent!=null){
            user.setText(intent.getStringExtra("email"));
        }

        logoutBtn.setOnClickListener{
            var intent=Intent(applicationContext,LoginScreen::class.java);
            startActivity(intent);
        }
    }
}
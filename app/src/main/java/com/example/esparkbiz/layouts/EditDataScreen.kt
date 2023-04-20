package com.example.esparkbiz.layouts

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.widget.AppCompatButton
import com.example.esparkbiz.R
import com.example.esparkbiz.database.DatabaseHelper
import com.example.esparkbiz.utils.Util
import com.google.android.material.textfield.TextInputEditText

class EditDataScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_data_screen)

        var username = findViewById<TextInputEditText>(R.id.edit_user_name);
        var email = findViewById<TextInputEditText>(R.id.edit_user_email);
        var city = findViewById<TextInputEditText>(R.id.edit_user_city);
        var address = findViewById<TextInputEditText>(R.id.edit_user_address);

        var editDataBtn = findViewById<AppCompatButton>(R.id.editDataBtn);

        var intent: Intent? = intent;

        if (intent != null) {
            username.setText(intent.getStringExtra("name").toString())
            email.setText(intent.getStringExtra("email").toString())
            city.setText(intent.getStringExtra("city").toString())
            address.setText(intent.getStringExtra("address").toString())
        }

        editDataBtn.setOnClickListener {
            var db=DatabaseHelper(applicationContext);
            var response =
                db.editData(
                    "1",
                    username.text.toString(),
                    email.text.toString(),
                    city.text.toString(),
                    address.text.toString()
                );
            Util.displayToast("Updated Successfully.", applicationContext);
        }
    }
}
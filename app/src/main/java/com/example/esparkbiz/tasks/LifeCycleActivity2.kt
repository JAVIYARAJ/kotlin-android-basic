package com.example.esparkbiz.tasks

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.esparkbiz.R
import com.example.esparkbiz.utils.Util

class LifeCycleActivity2 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle2)
        Util.displayToast("activity2 create method call",applicationContext);
        Log.d("LifeCycle","activity2 create method call");

        findViewById<Button>(R.id.activity1).setOnClickListener{
            var intent= Intent(applicationContext,LifeCycleActivity1::class.java);
            startActivity(intent);
        }
    }

    override fun onStart() {
        super.onStart()
        Util.displayToast("activity2 start method call",applicationContext);
        Log.d("LifeCycle","activity2 start method call");

    }

    override fun onPause() {
        super.onPause()
        Util.displayToast("activity2 pause method call",applicationContext);
        Log.d("LifeCycle","activity2 pause method call");

    }

    override fun onStop() {
        super.onStop()
        Util.displayToast("activity2 stop method call",applicationContext);
        Log.d("LifeCycle","activity2 stop method call");

    }

    override fun onResume() {
        super.onResume()
        Util.displayToast("activity2 resume method call",applicationContext);
        Log.d("LifeCycle","activity2 resume method call");

    }

    override fun onRestart() {
        super.onRestart()
        Util.displayToast("activity2 restart method call",applicationContext);
        Log.d("LifeCycle","activity2 restart method call");

    }
}
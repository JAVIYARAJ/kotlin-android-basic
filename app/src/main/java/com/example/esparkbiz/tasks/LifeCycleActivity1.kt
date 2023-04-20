package com.example.esparkbiz.tasks

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.esparkbiz.R
import com.example.esparkbiz.utils.Util

class LifeCycleActivity1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle1)
        Util.displayToast("activity1 create method call",applicationContext);
        Log.d("LifeCycle","activity1 create method call");
        findViewById<Button>(R.id.activity2).setOnClickListener{
            var intent=Intent(applicationContext,LifeCycleActivity2::class.java);
            startActivity(intent);
        }
    }

    override fun onStart() {
        super.onStart()
        Util.displayToast("activity1 start method call",applicationContext);
        Log.d("LifeCycle","activity1 start method call");

    }

    override fun onPause() {
        super.onPause()
        Util.displayToast("activity1 pause method call",applicationContext);
        Log.d("LifeCycle","activity1 pause method call");

    }

    override fun onStop() {
        super.onStop()
        Util.displayToast("activity1 stop method call",applicationContext);
        Log.d("LifeCycle","activity1 stop method call");

    }

    override fun onResume() {
        super.onResume()
        Util.displayToast("activity1 resume method call",applicationContext);
        Log.d("LifeCycle","activity1 resume method call");

    }

    override fun onRestart() {
        super.onRestart()
        Util.displayToast("activity1 restart method call",applicationContext);
        Log.d("LifeCycle","activity1 restart method call");

    }
}
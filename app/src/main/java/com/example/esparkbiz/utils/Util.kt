package com.example.esparkbiz.utils

import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.security.AccessControlContext
import java.util.Objects

class Util {
    companion object {
        fun displayToast(title: String, context: Context) {
            Toast.makeText(context, title, Toast.LENGTH_LONG).show();
        }

        fun saveDataIntoSharedPreference(
            values: MutableMap<String, Any>,
            context: Context,
            prefName: String,
            isOldValue:Boolean
        ) {

            var sharedPreferences = context.getSharedPreferences(
                prefName,
                AppCompatActivity.MODE_PRIVATE
            ).edit();


            for (i in values.iterator()) {
                sharedPreferences.putString(i.key, i.value.toString());
            }
            sharedPreferences.apply();
        }

    }

}
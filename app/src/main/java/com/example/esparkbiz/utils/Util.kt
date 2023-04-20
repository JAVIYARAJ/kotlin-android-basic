package com.example.esparkbiz.utils

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        ) {

            var sharedPreferences = context.getSharedPreferences(
                prefName, AppCompatActivity.MODE_PRIVATE
            ).edit();


            for (i in values.iterator()) {
                sharedPreferences.putString(i.key, i.value.toString());
            }
            sharedPreferences.apply();
        }

        fun clearSharedPreference(prefName: String, context: Context) {
            var sharedPreferences =
                context.getSharedPreferences(prefName, AppCompatActivity.MODE_PRIVATE).edit();
            sharedPreferences.clear().apply();
        }

        fun displayAlert(context: Context): Boolean {
            var temp = false;
            var alertBuilder =
                AlertDialog.Builder(context).setTitle("esparkbiz").setMessage("Are you sure?");
            alertBuilder.setPositiveButton("yes") { _, _ -> temp = true; }
            alertBuilder.setNegativeButton("No") { dialog, _ ->
                {
                    temp = false
                    dialog.dismiss();
                }
            }
            alertBuilder.show();
            return temp;
        }
    }

}
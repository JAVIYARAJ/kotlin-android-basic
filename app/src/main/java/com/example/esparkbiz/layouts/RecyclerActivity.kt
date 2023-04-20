package com.example.esparkbiz.layouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.esparkbiz.models.Employee;
import com.example.esparkbiz.R
import com.example.esparkbiz.adapters.CustomAdapter
import com.example.esparkbiz.database.DatabaseHelper
import com.google.android.material.textfield.TextInputEditText
import java.util.Objects

class RecyclerActivity : AppCompatActivity() {
    @SuppressLint("Range", "NotifyDataSetChanged", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler);

        //create spinner for search type
        var searchTypeDropdown=findViewById<Spinner>(R.id.queryType);

        var dropDownAdapter=ArrayAdapter.createFromResource(applicationContext,R.array.searchType,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        searchTypeDropdown.adapter=dropDownAdapter;



        var recyclerView = findViewById<RecyclerView>(R.id.employee_recyclerview);
        recyclerView.layoutManager = LinearLayoutManager(this)
        var employeeList = ArrayList<Employee>();

        var sharedPreferences = applicationContext.getSharedPreferences("user_info", MODE_PRIVATE);
        var data = sharedPreferences.getString("name", "test");

        var databaseHelper: DatabaseHelper = DatabaseHelper(applicationContext);

        var list = arrayListOf<Employee>();
        var fetchedData = databaseHelper.displayData();

        if (fetchedData.moveToFirst()) {
            do {
                var id = fetchedData.getInt(fetchedData.getColumnIndex("ID"))
                var name = fetchedData.getString(fetchedData.getColumnIndex("NAME"))
                var email = fetchedData.getString(fetchedData.getColumnIndex("EMAIL"))
                var city = fetchedData.getString(fetchedData.getColumnIndex("CITY"))
                var address = fetchedData.getString(fetchedData.getColumnIndex("ADDRESS"))
                var employee = Employee(id, 0, name, email, city, address, false);
                list.add(employee);
            } while (fetchedData.moveToNext());
        }


        var adapter = CustomAdapter(list, applicationContext)
        recyclerView.adapter = adapter;

        var addNewCard = findViewById<ImageView>(R.id.addNewCard);


        //notify method practice
        addNewCard.setOnClickListener {

            //this method use for change multiple items in recycler view (refresh all item)
            //list.add(Employee(1,0,"test","test@gmail.com","test","test",true));
            //adapter.notifyDataSetChanged()

            //new item inserted at specified position.
            //list.add(Employee(1,0,"test","test@gmail.com","test","test",true));
            //adapter.notifyItemInserted(0);

            //item change its data (crud operation) on recycler view item.
            //(refresh only one item)
            //list[0].name="raj kumar";
            //adapter.notifyItemChanged(0);

            //use when particular item removed
            //list.removeAt(0);
            //adapter.notifyItemRemoved(0);

            //use when recycler view item change its position.
            //adapter.notifyItemMoved(1,0);

            //if you are remove item (means change item range) then this method is used.
            //list.removeAt(0)
            //adapter.notifyItemRangeRemoved(0,list.size);

            //list.add(Employee(1,0,"test","test@gmail.com","test","test",true));
            //adapter.notifyItemRangeInserted(0,list.size);
        }


        //perform search functionality

        var query=findViewById<EditText>(R.id.filterText);

        //apply im option om edit text

        query.setOnEditorActionListener { _, actionId, _ ->
            //get selected drop down filter text
            var filterType=searchTypeDropdown.selectedItem.toString();

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                var filterList=ArrayList<Employee>();

                var selectArgs="$filterType = ?";

                var response=databaseHelper.filterData(null,selectArgs, arrayOf(query.text.toString()));
                if(response.moveToFirst()){
                    do{
                        var emp=Employee(response.getInt(response.getColumnIndex("ID")),0,response.getString(response.getColumnIndex("NAME")),response.getString(response.getColumnIndex("EMAIL")),response.getString(response.getColumnIndex("CITY")),response.getString(response.getColumnIndex("ADDRESS")),false);
                        filterList.add(emp);
                    }while (response.moveToNext());
                }
                list.clear();
                list.addAll(filterList);
                adapter.notifyDataSetChanged();
                true
            } else {
                false
            }
        }

    }
}


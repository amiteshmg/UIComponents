package com.example.aadyam.uicomponents;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SportsActivity extends AppCompatActivity
{

    ListView list;
    String item;
    ArrayAdapter<String> arrayAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);


       list=(ListView)findViewById(R.id.listViewSports);



        ArrayList<String> arraySports=new ArrayList<>();

        arraySports.addAll(Arrays.asList(getResources().getStringArray(R.array.sports_category)));

        arrayAdapter=new ArrayAdapter<>(SportsActivity.this,R.layout.sports_list,R.id.sports_entry_textview,arraySports);
        list.setAdapter(arrayAdapter);

       searchView=(SearchView)findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

       //list.getOnItemSelectedListener();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item=(String)parent.getItemAtPosition(position);

                Toast.makeText(SportsActivity.this,item, Toast.LENGTH_SHORT).show();

                if(position==0)
                {
                    // startActivity(intent);
                }
            }
        });




       // String[] sportarray=getResources().getStringArray(R.array.sports_category);
        //listView=(ListView)findViewById(R.id.listview);

        //this.setListAdapter(new ArrayAdapter<String>(this,R.layout.sports_list,R.id.sports_entry_textview,sportarray));

        //ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.sports_list,sportarray);

        //listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

     //   MenuInflater inflater=getMenuInflater();
       // inflater.inflate(R.menu.menu_search,menu);

        //MenuItem menuItem=menu.findItem(R.id.searchView);

        return super.onCreateOptionsMenu(menu);
    }

    void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

        item=(String)parent.getItemAtPosition(position);

        Toast.makeText(this,"nothing",Toast.LENGTH_SHORT).show();


    }
}

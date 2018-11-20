package com.example.aadyam.uicomponents;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

//import com.example.aadyam.uicomponentsdemo.R;

import java.util.ArrayList;

import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

//import com.example.aadyam.uicomponentsdemo.R;

public class Home extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
       /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
*/

        setTitle("Home");
        final Intent intent=new Intent(Home.this,MoviesActivity.class);
        final Intent intent1=new Intent(Home.this,BookTicketActivity.class);
        //final Intent intent3=new Intent(Home.this,DummyActivity.class);
        final Intent intent4 =new Intent(Home.this,EventsActivity.class);

        ImageButton movie_button,sports_button,events_button,plays_button;
        final  Intent intent2=new Intent(Home.this,SportsActivity.class);

        movie_button=(ImageButton)findViewById(R.id.movies);
        sports_button=(ImageButton)findViewById(R.id.sports);
        events_button=(ImageButton)findViewById(R.id.events);
        plays_button=(ImageButton)findViewById(R.id.plays);

        movie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(intent);
            }
        });

        sports_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(intent2);
            }
        });

        events_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(intent4);
            }
        });


        plays_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //startActivity(intent3);
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
}

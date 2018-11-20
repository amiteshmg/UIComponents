package com.example.aadyam.uicomponents;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookTicketActivity extends AppCompatActivity {


    public TextView moviename,moviedescription;
    public ImageView poster;
    private Context mContext;
    private List<Movie> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);

        moviename = (TextView)findViewById(R.id.title);
        moviedescription = (TextView)findViewById(R.id.description_edit);
        poster=(ImageView)findViewById(R.id.poster_imageview);






    }
}

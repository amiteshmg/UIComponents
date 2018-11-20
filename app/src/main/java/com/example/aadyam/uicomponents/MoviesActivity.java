package com.example.aadyam.uicomponents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity

{

    private RecyclerView recyclerView;
    private MoviesAdapter adapter;
    private List<Movie> MovieList;
    String[] movies;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SearchView searchView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        movies=getResources().getStringArray(R.array.movies);
         //searchView=(SearchView)findViewById(R.id.searchview);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);




        //toolbar code casting error - requires minimum API 21 above (Our API is15 minimum)




        /*  Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();
        */



        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        MovieList = new ArrayList<>();
        adapter = new MoviesAdapter(this, MovieList);
        recyclerView.setAdapter(adapter);



        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
       //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareMovies();

        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                for(int i=0;i<movies.length;i++) {
                    if (s.equals(movies[i]))
                    {
                        Toast.makeText(MoviesActivity.this,"found :"+movies[i],Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
*/


    }

    //my logic to search movie from search box

    private void searchMovies(String name)
    {



    }


    private void prepareMovies() {
        int[] covers = new int[]{
                R.mipmap.album2,
                R.mipmap.album3,
                R.mipmap.album4,
                R.mipmap.album5,
                R.mipmap.album6,
                R.mipmap.album7,
                R.mipmap.album8,
                R.mipmap.album9,
                R.mipmap.album10,
                R.mipmap.album11};


            Movie a = new Movie("Sanju", "Hindi U/A ", covers[0]);
            MovieList.add(a);

            a = new Movie("Wolf of the wall street ", "English U/A ", covers[1]);
            MovieList.add(a);

            a = new Movie("Tumbaad", "Tamil U/A ", covers[2]);
            MovieList.add(a);

            a = new Movie("Avengers:Infinity War", "English U/A ", covers[3]);
            MovieList.add(a);

            a = new Movie("Conjuring 3", "English U/A ", covers[4]);
            MovieList.add(a);

            a = new Movie("Don 3", "Hindi U/A ", covers[5]);
            MovieList.add(a);

            a = new Movie("Golmaal 5", "Hindi U/A ", covers[6]);
            MovieList.add(a);

            a = new Movie("Baahubali:The Beginning", "Hindi U/A ", covers[7]);
            MovieList.add(a);

            a = new Movie("Baahubali:The Beginning", "Hindi U/A ", covers[8]);
            MovieList.add(a);

            a = new Movie("Ra One", "Hindi U/A ", covers[9]);
            MovieList.add(a);

            adapter.notifyDataSetChanged();


    }





/*
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
*/
    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    private void initCollapsingToolbar()
    {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

//         hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}

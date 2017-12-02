package com.example.ashwin.gridlinearswitchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> mMoviesList;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private LinearAdapter mLinearAdapter;
    private GridAdapter mGridAdapter;
    private MenuItem mGridIcon, mListIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        initViews();
    }

    private void initList() {
        mMoviesList = new ArrayList<>();
        mMoviesList.add(new Movie(1, "Spiderman Homecoming", R.drawable.spiderman_homecoming));
        mMoviesList.add(new Movie(2, "Fate of the Furious", R.drawable.fate_of_the_furious));
        mMoviesList.add(new Movie(3, "Thor Ragnarok", R.drawable.thor_ragnarok));
        mMoviesList.add(new Movie(4, "Iron Man 2", R.drawable.iron_man_2));
        mMoviesList.add(new Movie(5, "Captain America - The Winter Soldier", R.drawable.captain_america_2));
        mMoviesList.add(new Movie(6, "Mission Impossible - Ghost Protocol", R.drawable.mission_impossible_4));
        mMoviesList.add(new Movie(7, "The Mummy", R.drawable.the_mummy));
        mMoviesList.add(new Movie(8, "Skyfall", R.drawable.skyfall));
        mMoviesList.add(new Movie(9, "War for Planet of Apes", R.drawable.war_for_planet_of_apes));
        mMoviesList.add(new Movie(10, "Justice League", R.drawable.justice_league));
        mMoviesList.add(new Movie(11, "Wonder Woman", R.drawable.wonder_woman));
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        setDefaultLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        mGridIcon = menu.findItem(R.id.action_grid);
        mGridIcon.setVisible(false);
        mListIcon = menu.findItem(R.id.action_list);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_grid:
                setGridLayout(true);
                break;
            case R.id.action_list:
                setGridLayout(false);
                break;
        }
        return true;
    }

    private void setDefaultLayout() {
        setGridLayout(true);
    }

    private void setGridLayout(boolean makeGrid) {
        if (makeGrid) {
            mLayoutManager = new GridLayoutManager(this, 2);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mLinearAdapter = null;
            mGridAdapter = new GridAdapter(this, mMoviesList);
            mRecyclerView.setAdapter(mGridAdapter);
        } else {
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mGridAdapter = null;
            mLinearAdapter = new LinearAdapter(this, mMoviesList);
            mRecyclerView.setAdapter(mLinearAdapter);
        }

        if (mGridIcon != null) {
            mGridIcon.setVisible(!makeGrid);
            mListIcon.setVisible(makeGrid);
        }
    }
}

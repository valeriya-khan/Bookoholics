package com.demo.bookaholics;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                searchView.clearFocus();
                if(hasFocus){
                    Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }

            }
        });
//        searchView.setIconifiedByDefault(false);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    public void onClickStartSearch(View view) {

    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate( R.menu.action_bar_menu, menu );
//
////        MenuItem menuItem = menu.findItem(R.id.options_menu_main_search);
//        // Add SearchWidget.
//        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
//        SearchView searchView = (SearchView) menu.findItem( R.id.options_menu_main_search ).getActionView();
//
//        searchView.setSearchableInfo( searchManager.getSearchableInfo( getComponentName() ) );
//        searchView.setIconifiedByDefault(false);
//
//        return true;
//    }
}
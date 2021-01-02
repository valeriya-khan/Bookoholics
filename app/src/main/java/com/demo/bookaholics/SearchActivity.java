package com.demo.bookaholics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.demo.bookaholics.adapters.SearchResultsAdapter;
import com.demo.bookaholics.pojo.Book;
import com.demo.bookaholics.viewmodel.MainViewModel;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private SearchView searchView;
    private MainViewModel viewModel;
    private SearchResultsAdapter adapter;
    private RecyclerView recyclerViewResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
//        handleIntent(getIntent());

        searchView = findViewById(R.id.searchViewInSearch);
        searchView.setIconifiedByDefault(false);
        searchView.requestFocus();
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.deleteAllBooks();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.loadBooks(query,"en","relevance",0);
                Log.i("myres","hello");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        recyclerViewResults = findViewById(R.id.recyclerViewSearchResult);
        adapter = new SearchResultsAdapter();
        recyclerViewResults.setAdapter(adapter);
        recyclerViewResults.setLayoutManager(new LinearLayoutManager(this));
        LiveData<List<Book>> booksFromLivedata = viewModel.getBooks();
        booksFromLivedata.observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                Log.i("myres", String.valueOf(books.size()));
                adapter.setBooks(books);
            }
        });

    }


    //    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        setIntent(intent);
//        handleIntent(intent);
//    }
//
//    private void handleIntent(Intent intent) {
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            viewModel.loadBooks(query,"en","relevance",0);
//            Log.i("myres","hello");
//        }
//    }

    public void onClickBackButton(View view) {
        finish();
    }
}
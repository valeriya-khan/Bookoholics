package com.demo.bookaholics.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.demo.bookaholics.api.ApiBookFactory;
import com.demo.bookaholics.api.ApiBookService;
import com.demo.bookaholics.data.BookDatabase;
import com.demo.bookaholics.pojo.Book;
import com.demo.bookaholics.pojo.BookResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    private static LiveData<List<Book>> books;
    private CompositeDisposable compositeDisposable;

    //Fieds connected with loading data
    private ApiBookFactory apiBookFactory;
    private ApiBookService apiBookService;
    private static final String API_KEY = "AIzaSyBAW5M8n3-39okyDitsXvKclCWwBRjJaU8";

    //Database
    private static BookDatabase bookDatabase;


    public MainViewModel(@NonNull Application application) {
        super(application);
        apiBookFactory = ApiBookFactory.getInstance();
        apiBookService = apiBookFactory.getApiBookService();
        compositeDisposable = new CompositeDisposable();
        bookDatabase = BookDatabase.getInstance(application);
        books = bookDatabase.bookDao().getAllBooks();
    }

    public LiveData<List<Book>> getBooks() {
        return books;
    }

    private void insertBooks(List<Book> books){
        new InsertBooksTask().execute(books);
    }


    private static class InsertBooksTask extends AsyncTask<List<Book>,Void,Void>{
        @Override
        protected Void doInBackground(List<Book>... lists) {
            if(lists!=null){
                bookDatabase.bookDao().insertBooks(lists[0]);
            }
            return null;
        }
    }

    public void deleteAllBooks(){
        new DeleteAllBooksTask().execute();
    }

    private static class DeleteAllBooksTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            bookDatabase.bookDao().deleteAllBooks();
            return null;
        }
    }

    public void loadBooks(String search_query, String lang_restriction, String order_by, int start_index){
        Disposable disposable = apiBookService.getBooks(API_KEY,search_query,lang_restriction,order_by,start_index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BookResponse>() {
                    @Override
                    public void accept(BookResponse bookResponse) throws Exception {
                        Toast.makeText(getApplication(),"success",Toast.LENGTH_SHORT).show();
                        deleteAllBooks();
                        List<Book> books = bookResponse.getBooks();
                        insertBooks(books);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getApplication(),throwable.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.i("myres",throwable.getMessage());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}

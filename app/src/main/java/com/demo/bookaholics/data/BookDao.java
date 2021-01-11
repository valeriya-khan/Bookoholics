package com.demo.bookaholics.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.demo.bookaholics.pojo.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Query("SELECT * FROM books")
    LiveData<List<Book>> getAllBooks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBooks(List<Book> books);

    @Query("DELETE FROM BOOKS")
    void deleteAllBooks();

    @Query("SELECT * FROM books WHERE bookId==:bookId")
    Book getBookById(String bookId);


}

package com.demo.bookaholics.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.demo.bookaholics.pojo.Book;

@Database(entities = {Book.class},version = 1,exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {

    private static BookDatabase bookDatabase;
    private static final String DB_NAME = "books.db";
    private static Object LOCK = new Object();

    public static BookDatabase getInstance(Context context){
        synchronized (LOCK){
            if(bookDatabase==null){
                bookDatabase = Room.databaseBuilder(context,BookDatabase.class,DB_NAME)
                        .fallbackToDestructiveMigration().build();
            }
        }
        return bookDatabase;
    }

    public abstract BookDao bookDao();

}

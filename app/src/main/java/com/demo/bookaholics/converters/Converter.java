package com.demo.bookaholics.converters;

import androidx.room.TypeConverter;

import com.demo.bookaholics.pojo.Book;
import com.demo.bookaholics.pojo.BookImageLinks;
import com.demo.bookaholics.pojo.BookIndustryIdentifier;
import com.demo.bookaholics.pojo.BookVolumeInfo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    @TypeConverter
    public String volumeInfoToString(BookVolumeInfo volumeInfo){
        return new Gson().toJson(volumeInfo);
    }

    @TypeConverter
    public BookVolumeInfo volumeInfoFromString(String volumeInfoAsString){
        return new Gson().fromJson(volumeInfoAsString,BookVolumeInfo.class);
    }

    @TypeConverter
    public String booksListToString(List<Book> books){
        return new Gson().toJson(books);
    }

    @TypeConverter
    public List<Book> booksListFromString(String booksAsString){
        Gson gson = new Gson();
        ArrayList objects = gson.fromJson(booksAsString,ArrayList.class);
        ArrayList<Book> books = new ArrayList<>();
        for(Object o:objects){
            books.add(gson.fromJson(o.toString(),Book.class));
        }
        return books;
    }

    @TypeConverter
    public String listOfStringsToString(List<String> strings){
        return new Gson().toJson(strings);
    }

    @TypeConverter
    public List<String> listOfStringsFromString(String listOfStringsAsString){
        Gson gson = new Gson();
        ArrayList objects = gson.fromJson(listOfStringsAsString,ArrayList.class);
        ArrayList<String> strings = new ArrayList<>();
        for(Object o:objects){
            strings.add(gson.fromJson(o.toString(),String.class));
        }
        return strings;
    }

    @TypeConverter
    public String listOfIndustryIdentifiersToString(List<BookIndustryIdentifier> industryIdentifiers){
        return new Gson().toJson(industryIdentifiers);
    }

    @TypeConverter
    public List<BookIndustryIdentifier> listOfIndustryIdentifiersFromString(String listOfIndustryIdentifiersAsString){
        Gson gson = new Gson();
        ArrayList objects = gson.fromJson(listOfIndustryIdentifiersAsString,ArrayList.class);
        ArrayList<BookIndustryIdentifier> identifiers = new ArrayList<>();
        for(Object o:objects){
            identifiers.add(gson.fromJson(o.toString(),BookIndustryIdentifier.class));
        }
        return identifiers;
    }

    @TypeConverter
    public String bookImageLinksToString(BookImageLinks links){
        return new Gson().toJson(links);
    }

    @TypeConverter
    public BookImageLinks bookImageLinksFromString(String bookImageLinksAsString){
        return new Gson().fromJson(bookImageLinksAsString,BookImageLinks.class);
    }



}

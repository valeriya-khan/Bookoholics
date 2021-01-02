package com.demo.bookaholics.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.bookaholics.R;
import com.demo.bookaholics.pojo.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.BookViewHolder> {
    List<Book> books;

    public SearchResultsAdapter() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);
        Log.i("myres",book.getBookVolumeInfo().getBookImageLinks().getBookImageSmallThumbnail());
        Picasso.get().load(book.getBookVolumeInfo().getBookImageLinks().getBookImageSmallThumbnail().replaceFirst("http","https")).placeholder(R.drawable.book_placeholder).into(holder.bookCover);
//        Picasso.get().load("https://cdn.pixabay.com/photo/2015/04/19/08/33/flower-729512__340.jpg").placeholder(R.drawable.ic_launcher_background).into(holder.bookCover);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        private ImageView bookCover;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookCover = itemView.findViewById(R.id.imageViewSmallCover);

        }
    }
}

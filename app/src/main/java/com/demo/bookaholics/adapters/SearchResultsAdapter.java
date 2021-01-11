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
    private List<Book> books;
    private OnReachEndListener onReachEndListener;

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

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        if(books.size()>=10 && position>books.size()-3 && onReachEndListener!=null){
            onReachEndListener.onReachEnd();
        }
        Log.i("adapter","size: "+books.size()+"pos: "+position);
        Book book = books.get(position);
        Log.i("title", book.getBookVolumeInfo().getBookTitle());

//        Picasso.get().load(bookImageLink.isEmpty() ? null : bookImageLink)
//                .placeholder(R.drawable.book_placeholder)
//                .error(R.drawable.book_placeholder)
//                .into(holder.bookCover);
        try {
            if(book.getBookVolumeInfo().getBookImageLinks()!=null){

                String bookImageLink = book.getBookVolumeInfo().getBookImageLinks().getBookImageSmallThumbnail().replaceFirst("http","https");
                Picasso.get().load(bookImageLink).placeholder(R.drawable.book_placeholder).into(holder.bookCover);
            }

//            Log.i("myres",book.getBookVolumeInfo().getBookImageLinks().getBookImageSmallThumbnail());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Picasso.get().load("https://cdn.pixabay.com/photo/2015/04/19/08/33/flower-729512__340.jpg").placeholder(R.drawable.ic_launcher_background).into(holder.bookCover);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public interface OnReachEndListener{
        void onReachEnd();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        private ImageView bookCover;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookCover = itemView.findViewById(R.id.imageViewSmallCover);
        }
    }
    public void clear(){
        this.books.clear();
        notifyDataSetChanged();
    }

    public void addBooks(List<Book> books){
        this.books.addAll(books);
        notifyDataSetChanged();
    }
}

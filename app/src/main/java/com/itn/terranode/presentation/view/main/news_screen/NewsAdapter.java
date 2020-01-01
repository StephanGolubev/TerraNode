package com.itn.terranode.presentation.view.main.news_screen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> newsList = new ArrayList<>();
    private OnItemClickListiner listiner;

    void setNews(List<News> newsList, OnItemClickListiner listiner){
        this.newsList.clear();
        this.newsList.addAll(newsList);
        this.listiner = listiner;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnItemClickListiner{
        void onItemClick(News news);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dateTextView)
        TextView dateTextView;
        @BindView(R.id.newsTitleTextView)
        TextView newsTitleTextView;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(News news){
            dateTextView.setText("");
            newsTitleTextView.setText("");
        };
    }
}

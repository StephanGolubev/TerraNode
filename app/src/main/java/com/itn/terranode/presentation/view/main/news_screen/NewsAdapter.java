package com.itn.terranode.presentation.view.main.news_screen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.NewsItem;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsItem> newsItems = new ArrayList<>();
    private OnItemClickListiner listiner;

    void setNews(List<NewsItem> newsItems, OnItemClickListiner listiner){
        this.newsItems.clear();
        this.newsItems.addAll(newsItems);
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
        holder.bind(newsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public interface OnItemClickListiner{
        void onItemClick(NewsItem newsItem);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dateTextView)
        TextView dateTextView;
        @BindView(R.id.newsTitleTextView)
        TextView newsTitleTextView;
        @BindView(R.id.newsCardView)
        CardView newsCardView;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(NewsItem newsItem){
            DateTimeFormatter incomeDateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter outgoingDateFormatter = DateTimeFormat.forPattern("dd MMMM yyyy");
            String date = outgoingDateFormatter.print(incomeDateFormatter.parseDateTime(newsItem.getCreatedAt()));
            dateTextView.setText(date);
            newsTitleTextView.setText(newsItem.getTitle());
            newsCardView.setOnClickListener(v -> listiner.onItemClick(newsItem));
        }
    }
}

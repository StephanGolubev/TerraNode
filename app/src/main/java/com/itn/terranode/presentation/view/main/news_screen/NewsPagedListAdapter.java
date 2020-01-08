package com.itn.terranode.presentation.view.main.news_screen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.NewsItem;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsPagedListAdapter extends PagedListAdapter<NewsItem, NewsPagedListAdapter.NewsViewHolder> {

    private static final DiffUtil.ItemCallback<NewsItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<NewsItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull NewsItem oldItem, @NonNull NewsItem newItem) {
            return oldItem.getTitle() == newItem.getTitle();
        }

        @Override
        public boolean areContentsTheSame(@NonNull NewsItem oldItem, @NonNull NewsItem newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected NewsPagedListAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem item = getItem(position);
        if(item != null){
            holder.bind(item);
        } else {
//            holder.clear();
        }

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
//            newsCardView.setOnClickListener(v -> listiner.onItemClick(newsItem));
        }
    }
}

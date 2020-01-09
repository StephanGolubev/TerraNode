package com.itn.terranode.presentation.view.main.news_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.presentation.presenter.main.news_screen.NewsPresenter;
import com.itn.terranode.presentation.view.main.MainActivity;
import com.itn.terranode.presentation.view.main.news_detail_screen.NewsDetailFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class NewsFragment extends MvpAppCompatFragment implements NewsView {

    @InjectPresenter
    NewsPresenter presenter;
    @BindView(R.id.screenNameTextView)
    TextView screenNameTextView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private Unbinder unbinder;
//    private NewsAdapter adapter;
    private NewsPagedListAdapter pagingAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initUI(view);
        screenNameTextView.setText("News");
        presenter.getNews();
        return view;
    }

    private void initUI(View view) {
        unbinder = ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        adapter = new NewsAdapter();
        pagingAdapter = new NewsPagedListAdapter();
        recyclerView.setAdapter(pagingAdapter);
    }

    @Override
    public void showNews(PagedList<NewsItem> newsItems) {
        pagingAdapter.submitList(newsItems);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}

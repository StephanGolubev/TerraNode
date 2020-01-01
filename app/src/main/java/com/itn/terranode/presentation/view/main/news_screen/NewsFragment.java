package com.itn.terranode.presentation.view.main.news_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.presentation.presenter.main.news_screen.NewsPresenter;

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

    private Unbinder unbinder;
    private NewsAdapter adapter;

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
        adapter = new NewsAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showNews(List<News> news) {
        adapter.setNews(news,  v -> {
            showToast("news selected");
        });
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}

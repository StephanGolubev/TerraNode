package com.itn.terranode.presentation.view.main.news_detail_screen;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.itn.terranode.R;
import com.itn.terranode.presentation.view.main.MainActivity;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NewsDetailFragment extends Fragment {

    private static final String DATE = "date";
    private static final String TITLE = "title";
    private static final String TEXT = "text";
    @BindView(R.id.screenNameTextView)
    TextView screenNameTextView;
    @BindView(R.id.dateTextView)
    TextView dateTextView;
    @BindView(R.id.webView)
    WebView webView;

    private Unbinder unbinder;
    private String date;
    private String title;
    private String text;

    public static Fragment newInstance(String createdAt, String title, String text){
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putString(DATE, createdAt);
        args.putString(TITLE, title);
        args.putString(TEXT, text);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        unbinder = ButterKnife.bind(this, view);
        if (getArguments() != null) {
            if (getArguments().getString(DATE) != null) {
                date = getArguments().getString(DATE);
            }
            if (getArguments().getString(TITLE) != null) {
                title = getArguments().getString(TITLE);
            }
            if (getArguments().getString(TEXT) != null) {
                text = getArguments().getString(TEXT);
            }
        }
        DateTimeFormatter incomeDateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter outgoingDateFormatter = DateTimeFormat.forPattern("dd MMMM yyyy");
        String resultDate = outgoingDateFormatter.print(incomeDateFormatter.parseDateTime(date));
        dateTextView.setText(resultDate);
        screenNameTextView.setText(title);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(null, text, "text/html", "utf-8", null);
    }

    @OnClick(R.id.backButton)
    public void onViewClicked() {
        ((MainActivity) getActivity()).removeFragment();
    }
}

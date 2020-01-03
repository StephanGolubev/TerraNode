package com.itn.terranode.presentation.view.main.products_detail_screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.itn.terranode.R;
import com.itn.terranode.presentation.view.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ProductsDetailFragment extends Fragment {

    private static final String URL = "URL";
    private static final String TITLE = "title";
    private static final String TEXT = "text";
    @BindView(R.id.screenNameTextView)
    TextView screenNameTextView;
    @BindView(R.id.viewMoreButton)
    Button viewMoreButton;
    @BindView(R.id.webView)
    WebView webView;

    private Unbinder unbinder;
    private String url;
    private String title;
    private String text;

    public static Fragment newInstance(String url, String title, String text) {
        ProductsDetailFragment fragment = new ProductsDetailFragment();
        Bundle args = new Bundle();
        args.putString(URL, url);
        args.putString(TITLE, title);
        args.putString(TEXT, text);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_detail, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        unbinder = ButterKnife.bind(this, view);
        if (getArguments() != null) {
            if (getArguments().getString(URL) != null) {
                url = getArguments().getString(URL);
            }
            if (getArguments().getString(TITLE) != null) {
                title = getArguments().getString(TITLE);
            }
            if (getArguments().getString(TEXT) != null) {
                text = getArguments().getString(TEXT);
            }
        }

        screenNameTextView.setText(title);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(null, text, "text/html", "utf-8", null);
    }

    @OnClick(R.id.backButton)
    void onViewClicked() {
        ((MainActivity) getActivity()).removeFragment();
    }


    @OnClick(R.id.viewMoreButton)
    void onViewMoreButtonClicked() {
        Uri address = Uri.parse(url);
        Intent openlink = new Intent(Intent.ACTION_VIEW, address);
        startActivity(Intent.createChooser(openlink, "Browser"));
    }
}

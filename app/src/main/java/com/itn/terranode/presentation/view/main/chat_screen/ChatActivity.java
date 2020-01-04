package com.itn.terranode.presentation.view.main.chat_screen;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.Chat;
import com.itn.terranode.data.network.dtos.ChatMessage;
import com.itn.terranode.presentation.presenter.main.chat_screen.ChatPresenter;
import com.itn.terranode.presentation.view.main.MainActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class ChatActivity extends MvpAppCompatActivity implements ChatView {

    @InjectPresenter
    ChatPresenter presenter;

    @BindView(R.id.screenNameTextView)
    TextView screenNameTextView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private ChatAdapter adapter;
    private LinearLayoutManager manager;
    private String userName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
        manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        manager.scrollToPosition(0);
        recyclerView.setLayoutManager(manager);
        adapter = new ChatAdapter();
        recyclerView.setAdapter(adapter);
        //условие
        if(getIntent().hasExtra("userId")){
            presenter.createChat(getIntent().getStringExtra("userId"));
        } else {
            if(getIntent().hasExtra("chatId")){
                presenter.getMessages(getIntent().getStringExtra("chatId"));
            }
        }
        if(getIntent().hasExtra("userName")){
            userName = getIntent().getStringExtra("userName");
        }

        screenNameTextView.setText(userName);
    }

    @Override
    public void showChat(List<ChatMessage> chatsList, String currentId) {
       adapter.setChatMessageList(chatsList, currentId, userName);
       manager.scrollToPosition(0);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.backButton)
    void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}

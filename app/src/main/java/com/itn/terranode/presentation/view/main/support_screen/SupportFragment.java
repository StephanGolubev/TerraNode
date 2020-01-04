package com.itn.terranode.presentation.view.main.support_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.Chat;
import com.itn.terranode.data.network.dtos.User;
import com.itn.terranode.presentation.presenter.main.support_screen.SupportPresenter;
import com.itn.terranode.presentation.view.main.MainActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class SupportFragment extends MvpAppCompatFragment implements SupportView {

    @InjectPresenter
    SupportPresenter presenter;

    @BindView(R.id.screenNameTextView)
    TextView screenNameTextView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.correspondenceRecyclerView)
    RecyclerView correspondenceRecyclerView;
    @BindView(R.id.structureRecyclerView)
    RecyclerView structureRecyclerView;

    private Unbinder unbinder;
    private UsersAdapter structureAdapter;
    private ChatsAdapter chatsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_support, container, false);
        initUI(view);
        presenter.getStructure();
        presenter.getChats();
        return view;
    }

    private void initUI(View view) {
        unbinder = ButterKnife.bind(this, view);
        screenNameTextView.setText("Support");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.search(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        structureRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        structureAdapter = new UsersAdapter();
        structureRecyclerView.setAdapter(structureAdapter);

        correspondenceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        chatsAdapter = new ChatsAdapter();
        correspondenceRecyclerView.setAdapter(chatsAdapter);
    }

    @Override
    public void showChats(List<Chat> chatsList) {
        chatsAdapter.setChatsList(chatsList, chat -> ((MainActivity) getActivity()).showChatActivityByChatId(chat.getChatId(), chat.getName()));
    }

    @Override
    public void showStructure(List<User> usersList) {
        structureAdapter.setUserList(usersList, user -> ((MainActivity) getActivity()).showChatActivityByUserId(user.getId(), user.getName()));
    }

    @Override
    public void showSearchResult(List<User> usersList) {
        showToast("мы что-то нашли");
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

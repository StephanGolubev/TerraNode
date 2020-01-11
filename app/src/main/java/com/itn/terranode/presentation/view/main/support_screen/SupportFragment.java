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
import androidx.core.widget.NestedScrollView;
import androidx.paging.PagedList;
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
    @BindView(R.id.searchRecyclerView)
    RecyclerView searchRecyclerView;
    @BindView(R.id.searchScrollView)
    NestedScrollView searchScrollView;
    @BindView(R.id.defaultScrollView)
    NestedScrollView defaultScrollView;

    private Unbinder unbinder;
    private UsersPagedAdapter structureAdapter;
    private UsersAdapter searchAdapter;
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
        showChatsAndStructure();
        screenNameTextView.setText(R.string.support);
        searchView.setActivated(true);
        searchView.setQueryHint("Search by name or number");
        searchView.setIconified(false);
        searchView.onActionViewExpanded();
        searchView.clearFocus();
        searchView.setOnCloseListener(() -> {
            showChatsAndStructure();
            return false;
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (QueryValidator.isValid(newText)) {
                    presenter.search(newText);
                } else {
                    showChatsAndStructure();
                }
                return true;
            }
        });

        structureRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        structureAdapter = new UsersPagedAdapter(user -> ((MainActivity) getActivity()).showChatActivityByUserId(user.getId(), user.getName()));
        structureRecyclerView.setAdapter(structureAdapter);

        searchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchAdapter = new UsersAdapter();
        searchRecyclerView.setAdapter(searchAdapter);

        correspondenceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        chatsAdapter = new ChatsAdapter();
        correspondenceRecyclerView.setAdapter(chatsAdapter);
    }

    @Override
    public void showChatsAndStructure() {
        defaultScrollView.setVisibility(View.VISIBLE);
        searchScrollView.setVisibility(View.GONE);
    }
    private void showSearch() {
        defaultScrollView.setVisibility(View.GONE);
        searchScrollView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showChats(List<Chat> chatsList) {
        chatsAdapter.setChatsList(chatsList, chat -> ((MainActivity) getActivity()).showChatActivityByChatId(chat.getChatId(), chat.getName()));
    }

    @Override
    public void showStructure(PagedList<User> usersList) {
        structureAdapter.submitList(usersList);
    }

    @Override
    public void showSearchResult(List<User> usersList) {
        searchAdapter.setUserList(usersList, user -> ((MainActivity) getActivity()).showChatActivityByUserId(user.getId(), user.getName()));
        showSearch();
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
        unbinder.unbind();
        presenter.destroy();
        super.onDestroy();
    }
}

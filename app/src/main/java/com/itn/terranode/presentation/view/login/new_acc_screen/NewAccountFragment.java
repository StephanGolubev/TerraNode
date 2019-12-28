package com.itn.terranode.presentation.view.login.new_acc_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.itn.terranode.R;
import com.itn.terranode.presentation.presenter.login.new_acc_screen.NewAccountPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class NewAccountFragment extends MvpAppCompatFragment implements NewAccountView {

    @BindView(R.id.fullNameEditText)
    TextInputEditText fullNameEditText;
    @BindView(R.id.emailEditText)
    TextInputEditText emailEditText;
    @BindView(R.id.passwordEditText)
    TextInputEditText passwordEditText;
    @BindView(R.id.sponsorIdEditText)
    TextInputEditText sponsorIdEditText;

    @InjectPresenter
    NewAccountPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_account, container, false);
        return view;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.createButton)
    public void onCreateButtonClicked() {
    }

    @OnClick(R.id.newAccountTextView)
    public void onNewAccountTextViewClicked() {
        presenter.createNewAccount(fullNameEditText.getText().toString(),
                emailEditText.getText().toString(),
                passwordEditText.getText().toString(),
                sponsorIdEditText.getText().toString());
    }
}

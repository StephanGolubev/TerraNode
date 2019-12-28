package com.itn.terranode.presentation.view.login.login_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.itn.terranode.R;
import com.itn.terranode.presentation.presenter.login.login_screen.LoginPresenter;
import com.itn.terranode.presentation.view.login.LoginActivity;
import com.itn.terranode.presentation.view.login.new_acc_screen.NewAccountFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class LoginScreenFragment extends MvpAppCompatFragment implements LoginScreenView {

    @BindView(R.id.loginEditText)
    TextInputEditText loginEditText;
    @BindView(R.id.passwordEditText)
    TextInputEditText passwordEditText;
    @BindView(R.id.newAccountTextView)
    TextView newAccountTextView;

    @InjectPresenter
    LoginPresenter presenter;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.loginButton)
    void onLoginButtonClicked() {
        presenter.login(loginEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @OnClick(R.id.newAccountTextView)
    void onNewAccountTextViewClicked() {
        ((LoginActivity) getActivity()).showFragment(new NewAccountFragment());
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}

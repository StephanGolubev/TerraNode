package com.itn.terranode.presentation.view.login.new_acc_screen;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.itn.terranode.R;
import com.itn.terranode.presentation.presenter.login.new_acc_screen.NewAccountPresenter;
import com.itn.terranode.presentation.view.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
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
    @BindView(R.id.newAccountTextView)
    TextView newAccountTextView;

    @InjectPresenter
    NewAccountPresenter presenter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_account, container, false);
        unbinder = ButterKnife.bind(this, view);
        SpannableString s = new SpannableString(getResources().getString(R.string.already_have_an_account_log_in));
        s.setSpan(new StyleSpan(Typeface.BOLD), 25, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(new UnderlineSpan(), 25, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        newAccountTextView.setText(s);
        return view;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.newAccountTextView)
    void onNewAccountTextViewClicked() {
        ((LoginActivity) getActivity()).onBackPressed();
    }

    @OnClick(R.id.createButton)
    void onCreateButtonClicked() {
        presenter.createNewAccount(fullNameEditText.getText().toString(),
                emailEditText.getText().toString(),
                passwordEditText.getText().toString(),
                sponsorIdEditText.getText().toString());
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

}

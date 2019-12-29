package com.itn.terranode.presentation.view.splash_screen;

import android.content.Intent;
import android.os.Bundle;

import com.itn.terranode.presentation.view.main.MainActivity;
import com.itn.terranode.R;
import com.itn.terranode.presentation.presenter.splash_screen.SplashScreenPresenter;
import com.itn.terranode.presentation.view.login.LoginActivity;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class SplashScreenActivity extends MvpAppCompatActivity implements SplashScreenView{

    @InjectPresenter
    SplashScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        presenter.checkIsUserLoggedIn();
    }

    @Override
    public void showMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

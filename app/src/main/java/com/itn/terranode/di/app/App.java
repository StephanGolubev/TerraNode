package com.itn.terranode.di.app;

import android.app.Application;

import androidx.annotation.NonNull;

import com.itn.terranode.di.login.login_screen.LoginComponent;
import com.itn.terranode.di.login.new_acc_screen.NewAccountComponent;
import com.itn.terranode.di.main.office_screen.OfficeComponent;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;
    private LoginComponent loginComponent;
    private NewAccountComponent newAccountComponent;
    private OfficeComponent officeComponent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .build();
    }

    @NonNull
    public LoginComponent plusLoginComponent() {
        if (loginComponent == null)
            loginComponent = appComponent.plusLoginComponent();
        return loginComponent;
    }

    public void clearLoginComponent() {
        loginComponent = null;
    }

    public NewAccountComponent plusNewAccountComponent() {
        if (newAccountComponent == null)
            newAccountComponent = appComponent.plusNewAccountComponent();
        return newAccountComponent;
    }

    public void clearNewAccountComponent() {
        newAccountComponent = null;
    }

    public OfficeComponent plusOfficeComponent() {
        if (officeComponent == null)
            officeComponent = appComponent.plusOfficeComponent();
        return officeComponent;
    }
}

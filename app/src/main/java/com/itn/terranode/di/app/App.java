package com.itn.terranode.di.app;

import android.app.Application;

import androidx.annotation.NonNull;

import com.itn.terranode.di.login.login_screen.LoginComponent;
import com.itn.terranode.di.login.new_acc_screen.NewAccountComponent;
import com.itn.terranode.di.main.chat_screen.ChatComponent;
import com.itn.terranode.di.main.news_screen.NewsComponent;
import com.itn.terranode.di.main.office_screen.OfficeComponent;
import com.itn.terranode.di.main.products_screen.ProductsComponent;
import com.itn.terranode.di.main.support_screen.SupportComponent;
import com.itn.terranode.di.splash_screen.SplashComponent;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;
    private SplashComponent splashComponent;
    private LoginComponent loginComponent;
    private NewAccountComponent newAccountComponent;
    private OfficeComponent officeComponent;
    private ProductsComponent productsComponent;
    private NewsComponent newsComponent;
    private SupportComponent supportComponent;
    private ChatComponent chatComponent;

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
                .factory()
                .create(this);
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

    public void clearOfficeComponent() {
        officeComponent = null;
    }

    public ProductsComponent plusProductsComponent() {
        if (productsComponent == null)
            productsComponent = appComponent.plusProductsComponent();
        return productsComponent;
    }

    public void clearProductsComponent() {
        productsComponent = null;
    }

    public NewsComponent plusNewsComponent() {
        if (newsComponent == null)
            newsComponent = appComponent.plusNewsComponent();
        return newsComponent;
    }

    public void clearNewsComponent() {
        newsComponent = null;
    }

    public SupportComponent plusSupportComponent() {
        if (supportComponent == null)
            supportComponent = appComponent.plusSupportComponent();
        return supportComponent;
    }

    public void clearSupportComponent() {
        supportComponent = null;
    }

    public ChatComponent plusChatComponent() {
        if (chatComponent == null)
            chatComponent = appComponent.plusChatComponent();
        return chatComponent;
    }

    public void clearChatComponent() {
        chatComponent = null;
    }

    public SplashComponent plusSplashComponent() {
        if (splashComponent == null)
            splashComponent = appComponent.plusSplashComponent();
        return splashComponent;
    }
}

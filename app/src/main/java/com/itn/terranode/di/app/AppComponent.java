package com.itn.terranode.di.app;

import android.content.Context;

import com.itn.terranode.di.login.login_screen.LoginComponent;
import com.itn.terranode.di.login.new_acc_screen.NewAccountComponent;
import com.itn.terranode.di.main.chat_screen.ChatComponent;
import com.itn.terranode.di.main.news_screen.NewsComponent;
import com.itn.terranode.di.main.office_screen.OfficeComponent;
import com.itn.terranode.di.main.products_screen.ProductsComponent;
import com.itn.terranode.di.main.support_screen.SupportComponent;
import com.itn.terranode.di.splash_screen.SplashComponent;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, PrefsModule.class})
public interface AppComponent {

    @Component.Factory
    interface Factory{
        AppComponent create(@BindsInstance Context context);
    }

    LoginComponent plusLoginComponent();

    NewAccountComponent plusNewAccountComponent();

    OfficeComponent plusOfficeComponent();

    ProductsComponent plusProductsComponent();

    NewsComponent plusNewsComponent();

    SupportComponent plusSupportComponent();

    ChatComponent plusChatComponent();

    SplashComponent plusSplashComponent();

    ReceiverComponent plusReceiverComponent();
}

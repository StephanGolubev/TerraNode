package com.itn.terranode.di.app;

import com.itn.terranode.di.login.login_screen.LoginComponent;
import com.itn.terranode.di.login.new_acc_screen.NewAccountComponent;
import com.itn.terranode.di.main.office_screen.OfficeComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface AppComponent {

    LoginComponent plusLoginComponent();

    NewAccountComponent plusNewAccountComponent();

    OfficeComponent plusOfficeComponent();
}

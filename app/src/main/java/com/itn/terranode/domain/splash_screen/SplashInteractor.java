package com.itn.terranode.domain.splash_screen;


import io.reactivex.Single;

public interface SplashInteractor {
    Single<Boolean> checkIfUserLoggedIn();
}

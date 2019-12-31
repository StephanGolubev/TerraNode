package com.itn.terranode.di.main.products_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.domain.main.products_screen.ProductsInteractor;
import com.itn.terranode.domain.main.products_screen.ProductsInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module
public interface ProductsModule {

    @Binds
    @AppScope
    ProductsInteractor provideProductsInteractor(ProductsInteractorImpl interactor);
}

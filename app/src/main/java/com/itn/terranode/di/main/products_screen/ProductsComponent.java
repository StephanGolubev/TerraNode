package com.itn.terranode.di.main.products_screen;

import com.itn.terranode.di.scopes.AppScope;
import com.itn.terranode.presentation.presenter.main.products_screen.ProductsPresenter;

import dagger.Subcomponent;

@AppScope
@Subcomponent(modules = ProductsModule.class)
public interface ProductsComponent {
    void inject(ProductsPresenter productsPresenter);
}

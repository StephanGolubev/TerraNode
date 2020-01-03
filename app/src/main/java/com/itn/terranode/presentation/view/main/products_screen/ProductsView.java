package com.itn.terranode.presentation.view.main.products_screen;

import com.itn.terranode.data.network.dtos.Product;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ProductsView extends MvpView {
    void showProducts(List<Product> products);

    void showToast(String message);

    void showProgressBar();

    void hideProgressBar();
}

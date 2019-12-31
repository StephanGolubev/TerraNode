package com.itn.terranode.presentation.view.main.products_screen;

import com.itn.terranode.data.network.dtos.InformationAboutUser;

import moxy.MvpView;

public interface ProductsView extends MvpView {
    void showProducts(InformationAboutUser data);

    void showToast(String message);
}

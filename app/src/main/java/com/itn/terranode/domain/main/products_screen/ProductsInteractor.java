package com.itn.terranode.domain.main.products_screen;

import com.itn.terranode.data.network.dtos.SuccessProductsResponse;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface ProductsInteractor {
    Maybe<SuccessProductsResponse> getProducts();
}

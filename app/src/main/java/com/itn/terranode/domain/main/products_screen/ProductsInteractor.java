package com.itn.terranode.domain.main.products_screen;

import io.reactivex.Maybe;
import retrofit2.Response;

public interface ProductsInteractor {
    Maybe<Response<Object>> getProducts();
}

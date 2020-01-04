package com.itn.terranode.presentation.view.main.products_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.Product;
import com.itn.terranode.presentation.presenter.main.products_screen.ProductsPresenter;
import com.itn.terranode.presentation.view.main.MainActivity;
import com.itn.terranode.presentation.view.main.products_detail_screen.ProductsDetailFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class ProductsFragment extends MvpAppCompatFragment implements ProductsView {

    @InjectPresenter
    ProductsPresenter presenter;
    @BindView(R.id.screenNameTextView)
    TextView screenNameTextView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Unbinder unbinder;
    private ProductsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        initUI(view);
        screenNameTextView.setText("Products");
        presenter.getProducts();
        return view;
    }

    private void initUI(View view) {
        unbinder = ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProductsAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProducts(List<Product> products) {
        adapter.setProductList(products, product -> ((MainActivity) getActivity()).showFragment(ProductsDetailFragment.newInstance(product.getUrl(), product.getName(), product.getText())));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}

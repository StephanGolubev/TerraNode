package com.itn.terranode.presentation.view.main.products_screen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.NewsItem;
import com.itn.terranode.data.network.dtos.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>{

    private List<Product> productList = new ArrayList<>();
    private OnItemClickListiner listiner;

    void setProductList(List<Product> productList, ProductsAdapter.OnItemClickListiner listiner){
        this.productList.clear();
        this.productList.addAll(productList);
        this.listiner = listiner;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.bind(productList.get(position));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public interface OnItemClickListiner{
        void onItemClick(Product product);
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.productNameTextView)
        TextView productNameTextView;
        @BindView(R.id.priceTextView)
        TextView priceTextView;
        @BindView(R.id.productCardView)
        CardView productCardView;

        ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Product product) {
            productNameTextView.setText(product.getName());
            priceTextView.setText("Available from $" + product.getPrice());
            productCardView.setOnClickListener(v -> listiner.onItemClick(product));
        }
    }
}

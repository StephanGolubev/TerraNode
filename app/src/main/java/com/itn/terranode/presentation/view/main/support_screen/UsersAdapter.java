package com.itn.terranode.presentation.view.main.support_screen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.Product;
import com.itn.terranode.data.network.dtos.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{

    private List<User> usersList = new ArrayList<>();
    private OnItemClickListiner listener;

    void setUserList(List<User> usersList, UsersAdapter.OnItemClickListiner listener){
        this.usersList.clear();
        this.usersList.addAll(usersList);
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.bind(usersList.get(position));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public interface OnItemClickListiner{
        void onItemClick(User user);
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.constraintLayout)
        ConstraintLayout constraintLayout;
        @BindView(R.id.userNameTextView)
        TextView userNameTextView;
        @BindView(R.id.personalIdTextView)
        TextView personalIdTextView;
        @BindView(R.id.photoImageView)
        CircleImageView photoImageView;

        UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(User user) {
            userNameTextView.setText(user.getName());
            personalIdTextView.setText("ID: " + user.getId());
            if(user.getPhoto() == null){
                photoImageView.setImageResource(R.drawable.user);
            } else {
                Picasso.get()
                        .load(user.getPhoto())
                        .into(photoImageView);
            }

            constraintLayout.setOnClickListener(v -> listener.onItemClick(user));
        }
    }
}

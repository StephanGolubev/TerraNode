package com.itn.terranode.presentation.view.main.support_screen;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.Chat;
import com.itn.terranode.data.network.dtos.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder>{

    private List<Chat> chatList = new ArrayList<>();
    private OnItemClickListiner listener;

    void setChatsList(List<Chat> chatList, ChatsAdapter.OnItemClickListiner listener){
        this.chatList.clear();
        this.chatList.addAll(chatList);
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ChatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsViewHolder holder, int position) {
        holder.bind(chatList.get(position));
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public interface OnItemClickListiner{
        void onItemClick(Chat chat);
    }

    class ChatsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userNameTextView)
        TextView userNameTextView;
        @BindView(R.id.constraintLayout)
        ConstraintLayout constraintLayout;
        @BindView(R.id.personalIdTextView)
        TextView personalIdTextView;
        @BindView(R.id.photoImageView)
        CircleImageView photoImageView;

        ChatsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Chat chat) {
            userNameTextView.setText(chat.getName());
//            if(chat.getIsRead().equals("0"))
//                userNameTextView.setTextColor(Color.RED);
//            else
//                userNameTextView.setTextColor(Color.BLACK);
            personalIdTextView.setText(chat.getLastMessage());
            if(chat.getPhoto() == null){
                photoImageView.setImageResource(R.drawable.user);
            } else {
                Picasso.get()
                        .load(chat.getPhoto())
                        .into(photoImageView);
            }
            constraintLayout.setOnClickListener(v -> listener.onItemClick(chat));
        }
    }
}

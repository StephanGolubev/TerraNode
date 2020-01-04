package com.itn.terranode.presentation.view.main.chat_screen;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.ChatMessage;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatMessage> chatsList = new ArrayList<>();
    private String currentId;
    private String userName = "";

    void setChatMessageList(List<ChatMessage> chatsList, String currentId, String userName) {
        this.chatsList.clear();
        this.chatsList.addAll(chatsList);
        this.currentId = currentId;
        this.userName = userName;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.bind(chatsList.get(position));
    }

    @Override
    public int getItemCount() {
        return chatsList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userNameTextView)
        TextView userNameTextView;
        @BindView(R.id.taskMessageItem)
        LinearLayout taskMessageItem;
        @BindView(R.id.messageTextView)
        TextView messageTextView;
        @BindView(R.id.messageCardView)
        CardView messageCardView;

        ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(ChatMessage chatMessage) {
            if (chatMessage.getUserId().equals(currentId)) {
                userNameTextView.setText(itemView.getResources().getString(R.string.you));
                userNameTextView.setTextColor(itemView.getResources().getColor(android.R.color.white));
                messageTextView.setText(chatMessage.getMessage());
                messageTextView.setTextColor(itemView.getResources().getColor(android.R.color.white));
                messageCardView.setBackgroundResource(R.drawable.background_chat_message);
                taskMessageItem.setGravity(Gravity.END);
            } else {
                userNameTextView.setText(userName);
                userNameTextView.setTextColor(itemView.getResources().getColor(R.color.textColor));
                messageTextView.setText(chatMessage.getMessage());
                messageTextView.setTextColor(itemView.getResources().getColor(R.color.textColor));
                messageCardView.setBackgroundResource(R.drawable.background_white_chat_message);
                taskMessageItem.setGravity(Gravity.START);
            }
        }
    }
}

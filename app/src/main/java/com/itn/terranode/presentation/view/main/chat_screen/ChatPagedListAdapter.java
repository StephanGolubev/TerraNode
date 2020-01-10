package com.itn.terranode.presentation.view.main.chat_screen;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.ChatMessage;
import com.itn.terranode.data.network.dtos.NewsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatPagedListAdapter extends PagedListAdapter<ChatMessage, ChatPagedListAdapter.ChatViewHolder> {


    private List<ChatMessage> chatsList = new ArrayList<>();
    private String currentId;
    private String userName = "";

    private static final DiffUtil.ItemCallback<ChatMessage> DIFF_CALLBACK = new DiffUtil.ItemCallback<ChatMessage>() {
        @Override
        public boolean areItemsTheSame(@NonNull ChatMessage oldItem, @NonNull ChatMessage newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ChatMessage oldItem, @NonNull ChatMessage newItem) {
            return oldItem.equals(newItem);
        }
    };

    ChatPagedListAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatMessage item = getItem(position);
        if(item != null) {
            holder.bind(item);
        }
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

    void setChatMessageList(String currentId, String userName) {
        this.currentId = currentId;
        this.userName = userName;
        notifyDataSetChanged();
    }
}


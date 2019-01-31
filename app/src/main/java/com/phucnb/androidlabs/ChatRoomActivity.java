package com.phucnb.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomActivity extends AppCompatActivity {

    ArrayList<Message> messageArrayList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chatroom);
        ChatAdapter adt = new ChatAdapter(getApplicationContext(), messageArrayList);

        ListView listView = (ListView)findViewById(R.id.ListView);
        Button sendBtn = (Button)findViewById(R.id.SendBtn);
        Button receiveBtn = (Button)findViewById(R.id.ReceiveBtn);
        listView.setAdapter(adt);
        sendBtn.setOnClickListener(c -> {
            Log.d("clicked","test");
            ((ChatAdapter) adt).notifyDataSetChanged();
        });




    }

    protected  class ChatAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<Message> messages;

        public ChatAdapter(Context context, ArrayList<Message> messages) {
            this.context = context;
            this.messages = messages;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return messages.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MessageViewHolder holder = new MessageViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            Message message = messages.get(position);

            if (message.isSender()){
                convertView = inflater.inflate(R.layout.activity_main_send, null);
                holder.avatar = (View)convertView.findViewById(R.id.senderAvatar);
                holder.message = (TextView)convertView.findViewById(R.id.senderMessage);
                convertView.setTag(holder);
                holder.message.setText(message.getMessage());
            } else {
                convertView = inflater.inflate(R.layout.activity_main_receive, null);
                holder.avatar = (View)convertView.findViewById(R.id.receiverAvatar);
                holder.message = (TextView)convertView.findViewById(R.id.receiverMessage);
                convertView.setTag(holder);
                holder.message.setText(message.getMessage());

            }
            return convertView;
        }
    }

    protected class MessageViewHolder {
        public View avatar;
        public TextView message;
    }
}


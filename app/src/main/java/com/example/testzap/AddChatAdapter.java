package com.example.testzap;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class AddChatAdapter extends FirestoreRecyclerAdapter<AddChatModel,AddChatAdapter.AddChatHolder> {

    public AddChatAdapter(@NonNull FirestoreRecyclerOptions<AddChatModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final AddChatHolder holder, int position, @NonNull final AddChatModel model) {

            holder.name.setText(model.Full_Name);
            holder.status.setText(model.status);
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  Intent intent=new Intent(view.getContext(),OpenProfileforChatUser.class);
                   intent.putExtra("Name",model.Full_Name);
                   intent.putExtra("Status",model.status);
                   intent.putExtra("Time",model.time_taken);
                   intent.putExtra("test",model.test_completed);
                   intent.putExtra("UserId",model.User_Id);
                   view.getContext().startActivity(intent);
                }
            });
    }

    @NonNull
    @Override
    public AddChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerforaddchat,
                parent, false);
        return new AddChatAdapter.AddChatHolder(v);
    }

    public class AddChatHolder extends RecyclerView.ViewHolder{
        TextView name,status;
        RelativeLayout relativeLayout;
        public AddChatHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.usernameforadd);
            status=itemView.findViewById(R.id.userStatus);
            relativeLayout=itemView.findViewById(R.id.recyclerforChats);
        }
    }
}

package com.example.finalopinionbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<model,myAdapter.viewHolder> {
    public myAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull model model)
    {
        holder.postText.setText(model.getPostText());
        holder.op1.setText(model.getOp1());
        holder.op2.setText(model.getOp2());
        //holder.username.setText(model.getUsername());
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_post, parent, false);
        return new viewHolder(view);
    }

    static class viewHolder extends RecyclerView.ViewHolder
    {

        TextView op1, op2, postText;
        //TextView username;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            postText =  itemView.findViewById(R.id.poll_question);
            op1 =  itemView.findViewById(R.id.poll_option1);
            op2 =  itemView.findViewById(R.id.poll_option2);
            //username = (TextView) itemView.findViewById(R.id.userName);
        }
    }




}

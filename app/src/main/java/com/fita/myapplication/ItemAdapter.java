package com.fita.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import static com.fita.myapplication.FirstScreen.EXTRA_MESSAGE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fita.myapplication.model.DataItem;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<DataItem> postAPIList;
    private Context mContext;

    public ItemAdapter(List<DataItem> postAPIList, Context mContext) {
        this.postAPIList = postAPIList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_name, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        holder.tvFirstname.setText(postAPIList.get(position).getFirstName());
        holder.tvLastname.setText(postAPIList.get(position).getLastName());
        holder.email.setText(postAPIList.get(position).getEmail());
        Glide.with(mContext)
                .load(postAPIList.get(position).getAvatar())
                .into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return postAPIList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFirstname, tvLastname, email;
        ImageView avatar;

        public ViewHolder(View view) {
            super(view);

            tvFirstname = itemView.findViewById(R.id.firstnameView);
            tvLastname = itemView.findViewById(R.id.lastnameView);
            email = itemView.findViewById(R.id.emailView);
            avatar = itemView.findViewById(R.id.myPict);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, SecondScreen.class);
                    mContext.startActivity(intent);
                    intent.putExtra("message", EXTRA_MESSAGE);
                }
            });
        }

    }
}

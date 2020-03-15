package com.dandara.nourishlocal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dandara.nourishlocal.MainActivity;
import com.dandara.nourishlocal.model.Community;
import com.dandara.nourishlocal.R;
import java.util.ArrayList;

public class CommunityRecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<Community> dataList;
    private Context context;
    public CommunityRecyclerAdapter(ArrayList<Community> list, Context context){
        this.dataList = list;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.communinty_list_item, parent, false);
        return new CommunityListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CommunityListAdapter.ViewHolder) holder).titleTextView.setText(dataList.get(position).getName());
        ((CommunityListAdapter.ViewHolder) holder).imageView.setImageResource(dataList.get(position).getImageReference());
        final int index = holder.getAdapterPosition();
        ((CommunityListAdapter.ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).getIntent(dataList.get(index));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

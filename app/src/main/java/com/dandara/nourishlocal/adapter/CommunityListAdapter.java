package com.dandara.nourishlocal.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dandara.nourishlocal.R;
import com.dandara.nourishlocal.model.Community;

import java.util.ArrayList;

public class CommunityListAdapter extends BaseAdapter {

    private ArrayList<Community> dataList;
    private Context context;
    public CommunityListAdapter(ArrayList<Community> list, Context context){
        this.dataList = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.communinty_list_item, parent, false);
        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView textView = rowView.findViewById(R.id.txtTitle);
        imageView.setImageResource(dataList.get(position).getImageReference());
        textView.setText(dataList.get(position).getName());
        return rowView;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView titleTextView;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            titleTextView = itemView.findViewById(R.id.txtTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

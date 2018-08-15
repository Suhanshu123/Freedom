package com.example.suhanshu.lucknowtourism.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suhanshu.lucknowtourism.R;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    int[] drawsid;
    String[] names;

    public AdapterClass(int[] drawsid, String[] names) {
        this.drawsid = drawsid;
        this.names = names;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(drawsid[position]);
        holder.textView.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.text_view);

        }
    }
}

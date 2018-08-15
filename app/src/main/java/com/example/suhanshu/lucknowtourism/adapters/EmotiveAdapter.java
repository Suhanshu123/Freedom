package com.example.suhanshu.lucknowtourism.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.suhanshu.lucknowtourism.R;
public class EmotiveAdapter extends RecyclerView.Adapter<EmotiveAdapter.MyEmoViewHolder> {
    int ids[]={R.drawable.pan2,R.drawable.bal3,R.drawable.neta,R.drawable.ram,R.drawable.mag,R.drawable.saor,R.drawable.sar,R.drawable.lal2,R.drawable.raje,R.drawable.azad,R.drawable.br};
    public EmotiveAdapter() {
    }
    @NonNull
    @Override
    public MyEmoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emotive_quotes, parent, false);
        return new MyEmoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyEmoViewHolder holder, int position) {
       holder.imageView.setImageResource(ids[position]);
    }

    @Override
    public int getItemCount() {
        return ids.length;
    }

    public class MyEmoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyEmoViewHolder(final View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_emo);
        }
    }
}

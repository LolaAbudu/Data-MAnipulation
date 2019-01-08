package com.example.lolaabudu.datamanipulation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {

    private List<Color> colorList;

    public ColorAdapter(List<Color> colorList){
        this.colorList=colorList;
    }


    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_itemview,parent,false);
        return new ColorViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder colorViewHolder, int position) {
        Color color = colorList.get(position);
        colorViewHolder.onBind(color);
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }
}

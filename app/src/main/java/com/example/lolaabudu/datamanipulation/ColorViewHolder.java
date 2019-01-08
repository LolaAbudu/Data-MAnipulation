package com.example.lolaabudu.datamanipulation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class ColorViewHolder extends RecyclerView.ViewHolder {

    private TextView color;
    private TextView category;
    private TextView type;
    private TextView code;


    public ColorViewHolder(@NonNull View itemView) {
        super(itemView);
        color = itemView.findViewById(R.id.color_color_textview);
        category = itemView.findViewById(R.id.color_category_textview);
        type = itemView.findViewById(R.id.color_type_textview);
        code = itemView.findViewById(R.id.color_code_textview);
    }

    public void onBind(Color colorBind) {
        color.setText(colorBind.getColor());
        category.setText(colorBind.getCategory());
        type.setText(colorBind.getType());
        code.setText(colorBind.getCode().toString());
    }
}

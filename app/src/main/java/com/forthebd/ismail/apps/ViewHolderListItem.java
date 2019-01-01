package com.forthebd.ismail.apps;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderListItem extends RecyclerView.ViewHolder {

    private TextView textView2;

    private String name;
    public ViewHolderListItem(@NonNull View itemView , final ListenerNameItem listenerNameItem) {
        super(itemView);

        CardView cardView = itemView.findViewById(R.id.CardViewList);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerNameItem.onClickItem(name);
            }
        });

        ImageView imageView = itemView.findViewById(R.id.ImageViewList);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerNameItem.onClickCross(name);
            }
        });

        this.textView2 = itemView
                .findViewById(R.id.List_text_name);

    }
    public void setContent(String name){
        this.name=name;
        textView2.setText(name);
    }
}

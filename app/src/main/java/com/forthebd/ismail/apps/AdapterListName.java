package com.forthebd.ismail.apps;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AdapterListName extends RecyclerView.Adapter<ViewHolderListItem> {

    private List<String> nameList;
    private final ListenerNameItem listenerNameItem;

    public AdapterListName(ListenerNameItem listenerNameItem) {
        this.listenerNameItem = listenerNameItem;
        this.nameList = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolderListItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_name_item,viewGroup,false);
        return new ViewHolderListItem(v,this.listenerNameItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListItem viewHolderListItem, int i) {
        viewHolderListItem.setContent(nameList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.nameList.size();
    }


    public void updateData(List<String> nameL){
        this.nameList.clear();
        this.nameList.addAll(nameL);
        notifyDataSetChanged();
    }
}

package com.example.passwordmanager;

import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardVH extends RecyclerView.ViewHolder {
    public TextView txt_title, txt_id, txt_pass,txt_option;
    public CardVH(@NonNull View itemView){
        super(itemView);
        txt_title = itemView.findViewById(R.id.crd_title);
        txt_id = itemView.findViewById(R.id.crd_id);
        txt_pass = itemView.findViewById(R.id.crd_pass);
        txt_option = itemView.findViewById(R.id.text_option);

    }
}

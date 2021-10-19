package com.example.passwordmanager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Card> list = new ArrayList<>();

    public RVAdapter(Context ctx){
        this.context = ctx;
    }

    public void setItems(ArrayList<Card> crd){
        list.addAll(crd);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.layout_items,parent,false);
        return new CardVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CardVH vh = (CardVH)holder;
        Card crd = list.get(position);
        vh.txt_title.setText(crd.getTitle());
        vh.txt_id.setText(crd.getId());
        vh.txt_pass.setText(crd.getPassword());
        vh.txt_option.setOnClickListener(v->{
            PopupMenu popupMenu = new PopupMenu(context,vh.txt_option);
            popupMenu.inflate(R.menu.options_menu);
            popupMenu.setOnMenuItemClickListener(item->{
                switch(item.getItemId()){
                    case R.id.menu_edit:
                        Intent intent = new Intent(context,addCard.class);
                        intent.putExtra("Edit",crd);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_remove:
                        DOAcard doa = new DOAcard();
                        doa.remove(crd.getKey()).addOnSuccessListener(suc->{
                            Toast.makeText(context,"Record is Removed",Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                        }).addOnFailureListener(er->{
                            Toast.makeText(context,""+er.getMessage(),Toast.LENGTH_SHORT).show();
                        });
                        Intent intent1 = new Intent(context,HomePageActivity.class);
                        context.startActivity(intent1);
                        break;
                }
                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

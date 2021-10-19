package com.example.passwordmanager;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DOAcard {
    private DatabaseReference databaseReference;

    public DOAcard(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Card.class.getSimpleName());
    }

    public Task<Void> add(Card crd){
        return databaseReference.push().setValue(crd);
    }

    public Task<Void> update(String key, HashMap<String,Object> hashMap){
        System.out.println(hashMap);
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public  Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }


    public Query get(){
        return databaseReference.orderByKey();
    }

}

package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class addCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        EditText et_title = findViewById(R.id.et_title);
        EditText et_id = findViewById(R.id.et_id);
        EditText et_pass = findViewById(R.id.et_pass);

        Button btn_add = findViewById(R.id.et_add);
        DOAcard doa = new DOAcard();

        btn_add.setOnClickListener(v->{
            Card crd = new Card(et_title.getText().toString(), et_id.getText().toString(),et_pass.getText().toString());
            doa.add(crd).addOnSuccessListener(suc->{
                Toast.makeText(this,"New Card Inserted" ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(addCard.this,HomePageActivity.class);
                startActivity(intent);
            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

        Card crd_edit = (Card)getIntent().getSerializableExtra("Edit");
        if(crd_edit != null){
            btn_add.setText("UPDATE");
            et_title.setText(crd_edit.getTitle());
            et_id.setText(crd_edit.getId());
            et_pass.setText(crd_edit.getPassword());
            btn_add.setOnClickListener(v->{
                HashMap<String , Object> hashMap = new HashMap<>();
                hashMap.put("title", et_title.getText().toString());
                hashMap.put("id",et_id.getText().toString());
                hashMap.put("password", et_pass.getText().toString());
                doa.update(crd_edit.getKey(),hashMap).addOnSuccessListener(suc->{
                    Toast.makeText(this,"Record is Updated", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent1 = new Intent(addCard.this,HomePageActivity.class);
                    startActivity(intent1);
                }).addOnFailureListener(er->{
                    Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
                });
            });
        }
    }
}
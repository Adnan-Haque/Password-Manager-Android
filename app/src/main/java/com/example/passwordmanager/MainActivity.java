package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;
    private Button etLogin;

    private final String Username = "Admin";
    private final String Password = "1234";

    boolean isValidate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etname);
        etPassword = findViewById(R.id.etpassword);
        etLogin = findViewById(R.id.etlogin);

        etLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = etName.getText().toString();
                String inputPassword = etPassword.getText().toString();
                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                }else{
                    isValidate = validate(inputName , inputPassword);

                    if(!isValidate){
                        Toast.makeText(MainActivity.this, "User Credentials are incorrect", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        // Add the code to go to new Activity.
                        Intent intent = new Intent(MainActivity.this , HomePageActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });

    }

    private boolean validate(String name , String password){
        if(name.equals(Username) && password.equals(Password)){
            return true;
        }
        return false;
    }
}
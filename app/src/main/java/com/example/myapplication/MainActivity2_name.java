package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class MainActivity2_name extends AppCompatActivity {
    EditText editText;
    Button button;
    String phone;
    FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phone=getIntent().getStringExtra("phonenumber");
        setContentView(R.layout.activity_main_activity2_name);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button4);

        firebaseDatabase=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
        firebaseStorage=FirebaseStorage.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editText.getText().toString();
                String number=phone;
                String uId=auth.getUid();
                user user=new user(uId,name,number);
                firebaseDatabase.getReference()
                        .child("user")
                        .child(auth.getUid()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity2_name.this, "Registered successful ", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity2_name.this,MainActivity4_home.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
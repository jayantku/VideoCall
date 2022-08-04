package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity2_phoneno extends AppCompatActivity {
EditText editText;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_phoneno);
       editText=findViewById(R.id.editTextPhone);
       button=findViewById(R.id.button2);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              if(editText.getText().toString().trim().isEmpty())
              {
                  Toast.makeText(MainActivity2_phoneno.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
              }
               PhoneAuthProvider.getInstance().verifyPhoneNumber(
                       "+91" + editText.getText().toString(), 60, TimeUnit.SECONDS,
                       MainActivity2_phoneno.this,
                       new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                           @Override
                           public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                           }

                           @Override
                           public void onVerificationFailed(@NonNull FirebaseException e) {
                               Toast.makeText(MainActivity2_phoneno.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                           }

                           @Override
                           public void onCodeSent(@NonNull String VerificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                               Intent intent=new Intent(MainActivity2_phoneno.this,MainActivity3_otp.class);
                               intent.putExtra("phonenumber",editText.getText().toString());
                               intent.putExtra("verificationId",VerificationId);
                               startActivity(intent);
                           }
                       }
               );
           }
       });
    }
}
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainActivity4HomeBinding;
import com.google.firebase.auth.FirebaseAuth;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity4_home extends AppCompatActivity {
    ActivityMainActivity4HomeBinding binding;
    FirebaseAuth auth;
    Button button1,button2;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_home);
        auth = FirebaseAuth.getInstance();
        //replacefragment(new historyFragment());
        button1=findViewById(R.id.button16);
        button2=findViewById(R.id.shareBtn17);
        editText=findViewById(R.id.codeBox);
        URL serverurl;
        try{
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))

                    .build();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4_home.this,MainActivity2_test.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (text.length() > 0) {
                    // creating a room using  JitsiMeetConferenceOptions class
                    // here .setRoom() method will set the text in room name
                    // here launch method with launch a new room to user where
                    // they can invite others too.
                    JitsiMeetConferenceOptions options
                            = new JitsiMeetConferenceOptions.Builder()
                            .setRoom(text)
                            .build();
                    JitsiMeetActivity.launch(MainActivity4_home.this, options);
                }
                else {
                    Toast.makeText(MainActivity4_home.this, "Enter The Code", Toast.LENGTH_SHORT).show();
                }
            }
        });

       /* binding = ActivityMainActivity4HomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomnavigationview.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
               // case R.id.home:
                 //   replacefragment(new homeFragment());
                   // Toast.makeText(MainActivity4_home.this, "home clicked", Toast.LENGTH_SHORT).show();
                   // break;

                case R.id.history:
                    replacefragment(new historyFragment());
                    Toast.makeText(MainActivity4_home.this, "history clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.logout:
                    auth.signOut();

                    Intent intent=new Intent(MainActivity4_home.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
            }
            return true;
        });*/

    }
  /* private void replacefragment(Fragment fragment)
    {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }*/
}
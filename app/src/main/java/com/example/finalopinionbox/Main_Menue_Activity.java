package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Menue_Activity extends AppCompatActivity {
    private static final String TAG = "Main_Menue_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main__menue);
        Button postbtn = findViewById(R.id.postMainBtn);
        Button addpostbtn = findViewById(R.id.addPostMainBtn);
        Button eventbtn = findViewById(R.id.eventMainBtn);
        Button accountbtn = findViewById(R.id.accountMainBtn);

        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Menue_Activity.this , PostMainActivity.class));
                Log.d(TAG, "goToPost: GOING TO PostMainActivity" );
            }
        });

        addpostbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Menue_Activity.this , AddPostMainActivity.class));
                Log.d(TAG, "goToPost: GOING TO AddPostMainActivity" );
            }
        });

        eventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Menue_Activity.this , EventMainActivity.class));
                Log.d(TAG, "goToPost: GOING TO EventMainActivity" );
            }
        });

        accountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Menue_Activity.this , AccountMainActivity.class));
                Log.d(TAG, "goToPost: GOING TO EventMainActivity" );
            }
        });
    }

//    public void goToPost(View view) {
//            startActivity(new Intent(Main_Menue_Activity.this , PostMainActivity.class));
//            Log.d(TAG, "goToPost: GOING TO PostMainActivity" );
//    }
//
//    public void goToAddPost(View view) {
//        startActivity(new Intent(Main_Menue_Activity.this , AddPostMainActivity.class));
//        Log.d(TAG, "goToPost: GOING TO AddPostMainActivity" );
//    }
//
//// change here later on
//    public void goToEvent(View view) {
//        startActivity(new Intent(Main_Menue_Activity.this , EventMainActivity.class));
//        Log.d(TAG, "goToPost: GOING TO EventMainActivity" );
//    }
//
//    public void goToAccount(View view) {
//        startActivity(new Intent(Main_Menue_Activity.this , AccountMainActivity.class));
//        Log.d(TAG, "goToPost: GOING TO EventMainActivity" );
//    }
}
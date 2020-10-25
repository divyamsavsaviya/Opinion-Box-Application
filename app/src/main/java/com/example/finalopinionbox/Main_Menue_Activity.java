package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Menue_Activity extends AppCompatActivity {

    private static final String TAG = "Main_Menue_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menue);
    }

    public void goToPost(View view) {
        startActivity(new Intent(Main_Menue_Activity.this , PostMainActivity.class));
        Log.d(TAG, "goToPost: GOING TO PostMainActivity" );
    }

    public void goToAddPost(View view) {
        startActivity(new Intent(Main_Menue_Activity.this , AddPostMainActivity.class));
        Log.d(TAG, "goToPost: GOING TO AddPostMainActivity" );
    }
// change here later on
    public void goToEvent(View view) {
        startActivity(new Intent(Main_Menue_Activity.this , EventMainActivity.class));
        Log.d(TAG, "goToPost: GOING TO EventMainActivity" );
    }

    public void goToAccount(View view) {
        startActivity(new Intent(Main_Menue_Activity.this , AccountMainActivity.class));
        Log.d(TAG, "goToPost: GOING TO EventMainActivity" );
    }

}
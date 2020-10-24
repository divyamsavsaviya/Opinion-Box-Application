package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AddPostMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post_main);
    }

    public void addPoll(View view) {
        startActivity(new Intent(this,AddPollOptionActivity.class));
    }

    public void addEvent(View view) {
        startActivity(new Intent(this, AddEventOptionActivity.class));
    }
}
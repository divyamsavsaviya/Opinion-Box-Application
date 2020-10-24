package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FirebaseAuth.getInstance().getCurrentUser() == null ) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish(); // user will not go to main activity by back button
        } else{
            startActivity(new Intent( this , Main_Menue_Activity.class));
            finish();
        }

//        if (FirebaseAuth.getInstance().getCurrentUser() != null ) {
//            startActivity(new Intent(this, Main_Menue_Activity.class));
//            finish();
//        }
    }
}

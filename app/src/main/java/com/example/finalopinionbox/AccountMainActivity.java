package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountMainActivity extends AppCompatActivity {

    private TextView displaynamefield;
    private TextView displayemailfield;
    private TextView displaybranchfield;
    private TextView displayPhonefield;

    private Button logout_btn;
//    private String providerId;
//    private String uid;
    private String name;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_main);
        logout_btn = (Button)  findViewById(R.id.logoutBTN);

        GetInfoActivity getInfoActivity = new GetInfoActivity();

        displaynamefield = findViewById(R.id.displayNameTv);
        displayemailfield = findViewById(R.id.displayEmailTv);
        displaybranchfield = findViewById(R.id.displayBranchTv);
        displayPhonefield = findViewById(R.id.displayContactTv);


        displaynamefield.setText(getInfoActivity.UserName);
        displayemailfield.setText("user@gmail.com");
        displaybranchfield.setText(getInfoActivity.UserBranch);
        displayPhonefield.setText(getInfoActivity.UserPhone);




        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (v.getId() == R.id.logoutBTN) {
                    AuthUI.getInstance()
                            .signOut(AccountMainActivity.this)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                public void onComplete(@NonNull Task<Void> task) {
                                    // user is now signed out
                                    startActivity(new Intent(AccountMainActivity.this, LoginActivity.class));
                                    finish();
                                }
                            });
                }
            }
        });

    }




}
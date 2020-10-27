package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class AccountMainActivity extends AppCompatActivity {

    private TextView displaynamefield;
    private TextView displayemailfield;
    private TextView displaybranchfield;
    private TextView displayPhonefield;
    public DatabaseReference mDatabase;

    public String UserPhone;
    public String UserBranch;


    private Button logout_btn;
//    private String providerId;
//    private String uid;
//    private String name;
//    private String email;
    public FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_main);
        logout_btn = (Button)  findViewById(R.id.logoutBTN);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        GetInfoActivity getInfoActivity = new GetInfoActivity();
        user = FirebaseAuth.getInstance().getCurrentUser();

        displaynamefield = findViewById(R.id.displayNameTv);
        displayemailfield = findViewById(R.id.displayEmailTv);
        displaybranchfield = findViewById(R.id.displayBranchTv);
        displayPhonefield = findViewById(R.id.displayContactTv);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String DisplayPhone = snapshot.child("Phone").getValue().toString();
                displayPhonefield.setText(DisplayPhone);

                String DisplayBranch = snapshot.child("Branch").getValue().toString();
                displayPhonefield.setText(DisplayBranch);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        displaynamefield.setText(user.getDisplayName());
        displayemailfield.setText(user.getEmail());


//        displaybranchfield.setText(getInfoActivity.UserBranch);
//        displayPhonefield.setText(getInfoActivity.UserPhone);
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
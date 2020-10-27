package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class GetInfoActivity extends AppCompatActivity {
    private static final String TAG = "GetInfoActivity";
    private EditText nameET;
    private EditText phoneET;
    private EditText collegeIdET;
    private Spinner BranchSelectorsSpinner;

    public DatabaseReference mDatabase;

//    private DatabaseReference mDatabase;


    public String UserName;
    public String UserCollegeId;
    public String UserPhone;
    public String UserBranch;
    public long UserBranchID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        //assigning EditText
        nameET = findViewById(R.id.TextDisplayName);
        collegeIdET = findViewById(R.id.TextCollegeId);
        phoneET = findViewById(R.id.TextPhone);
        BranchSelectorsSpinner =  findViewById(R.id.BranchSelection);

        UserCollegeId = collegeIdET.getText().toString().trim();
        UserPhone = phoneET.getText().toString().trim();
        UserBranch = BranchSelectorsSpinner.getSelectedItem().toString() ;
        UserBranchID =  BranchSelectorsSpinner.getSelectedItemId();


        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.branch_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        BranchSelectorsSpinner.setAdapter(adapter);

        // selecting values
        BranchSelectorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemSelected: " + parent.getSelectedItemId());
                Log.d(TAG, "onItemSelected: " + parent.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("users")
                .child(user.getUid())
                .child("Phone").setValue(UserPhone);

        mDatabase.child("users")
                .child(user.getUid())
                .child("Branch").setValue(UserBranch);

        mDatabase.child("users")
                .child(user.getUid())
                .child("BranchID").setValue(UserBranchID);

//        Firebase mUserInfo = new Firebase("https://finalopinionbox.firebaseio.com/Users/" + finalNameEnterByUser );
//
//        Firebase mUserName  = mUserInfo.child("Name");
//        Firebase mUserCollegeID  = mUserInfo.child("College ID");
//        Firebase mUserPhone  = mUserInfo.child("Phone");
//        Firebase mUserBranch  = mUserInfo.child("Branch");
//        Firebase mUserBranchId = mUserInfo.child("BranchId");
//
//
//        mUserName.setValue(UserName);
//        mUserCollegeID.setValue(UserCollegeId);
//        mUserPhone.setValue(UserPhone);
//        mUserBranch.setValue(UserBranch);
//        mUserBranchId.setValue(UserBranchID);

    }


    public void finish(View view) {
        startActivity(new Intent(GetInfoActivity.this, Main_Menue_Activity.class));
        Toast.makeText(getApplicationContext() , "Profile Updated :) you may Proceed " , Toast.LENGTH_LONG).show();
        finish();
    }

}





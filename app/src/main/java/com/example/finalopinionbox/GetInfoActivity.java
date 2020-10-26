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


public class GetInfoActivity extends AppCompatActivity {
    private static final String TAG = "GetInfoActivity";
    private EditText nameET;
    private EditText phoneET;
    private EditText collegeIdET;
    private Spinner BranchSelectorsSpinner;

    public String UserName;
    public String UserCollegeId;
    public String UserPhone;
    public String UserBranch;
    public long UserBranchID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);
        nameET = findViewById(R.id.TextDisplayName);
        collegeIdET = findViewById(R.id.TextCollegeId);
        phoneET = findViewById(R.id.TextPhone);
        BranchSelectorsSpinner =  findViewById(R.id.BranchSelection);


        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.branch_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        BranchSelectorsSpinner.setAdapter(adapter);

        // assigning values from EditText
        UserName = nameET.getText().toString().trim();
        UserCollegeId = collegeIdET.getText().toString().toUpperCase().trim();
        UserBranch = BranchSelectorsSpinner.getSelectedItem().toString().trim();
        UserBranchID = BranchSelectorsSpinner.getSelectedItemId();
        UserPhone = phoneET.getText().toString().trim();

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


//        // using String methode for changing " " with "_"
//        // ex enter name is Divyam Savsaviya after applying it will be
//        //                  Divyam_Savsaviya
//
//        String finalNameEnterByUser = UserName.replaceAll(" " , "_");
//
//        Firebase mUserInfo = new Firebase("https://finalopinionbox.firebaseio.com/Users");
//
//        Firebase mUserchild = mUserInfo.child(finalNameEnterByUser);
//
//        Firebase mUserName  = mUserchild.child("Name");
//        Firebase mUserCollegeID  = mUserchild.child("College ID");
//        Firebase mUserPhone  = mUserchild.child("Phone");
//        Firebase mUserBranch  = mUserchild.child("Branch");
//        Firebase mUserBranchId = mUserchild.child("BranchId");
//
//        mUserName.setValue(UserName);
//        mUserCollegeID.setValue(UserCollegeId);
//        mUserPhone.setValue(UserPhone);
//        mUserBranch.setValue(UserBranch);
//        mUserBranchId.setValue(UserBranchID);
//
//        Toast.makeText(getApplicationContext() , "Profile Updated :) you may Proceed " , Toast.LENGTH_LONG).show();

    }

    public void finish(View view) {
        startActivity(new Intent(GetInfoActivity.this, Main_Menue_Activity.class));
        InfoUpdated();
        finish();
    }

    public  void InfoUpdated(){
        // using String methode for changing " " with "_"
        // ex. entered name is Divyam Savsaviya after applying it will be
        //                     Divyam_Savsaviya

        String finalNameEnterByUser = UserName.replaceAll(" " , "_").trim();
        Firebase mUserInfo = new Firebase("https://finalopinionbox.firebaseio.com/Users/" + finalNameEnterByUser );

        Firebase mUserName  = mUserInfo.child("Name");
        Firebase mUserCollegeID  = mUserInfo.child("College ID");
        Firebase mUserPhone  = mUserInfo.child("Phone");
        Firebase mUserBranch  = mUserInfo.child("Branch");
        Firebase mUserBranchId = mUserInfo.child("BranchId");

        mUserName.setValue(UserName);
        mUserCollegeID.setValue(UserCollegeId);
        mUserPhone.setValue(UserPhone);
        mUserBranch.setValue(UserBranch);
        mUserBranchId.setValue(UserBranchID);

        Toast.makeText(getApplicationContext() , "Profile Updated :) you may Proceed " , Toast.LENGTH_LONG).show();
    }
}


package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class GetInfoActivity extends AppCompatActivity {
    private static final String TAG = "GetInfoActivity";
    public String selectedBranch;
    public long selectedBranchId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        Spinner spinner = (Spinner) findViewById(R.id.BranchSelection);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.branch_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemSelected: " + parent.getSelectedItemId());
                Log.d(TAG, "onItemSelected: " + parent.getSelectedItem());


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

         selectedBranch = spinner.getSelectedItem().toString();
         selectedBranchId = spinner.getSelectedItemId();



    }

    public void finish(View view) {
        startActivity(new Intent(GetInfoActivity.this, Main_Menue_Activity.class));
        finish();
    }
}


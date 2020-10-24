package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.finalopinionbox.R.id.btnpost;

//import android.widget.Checkable;

public class TargetFilterActivity extends AppCompatActivity {

    CheckBox compEng, civilEng, mechEng, electEng, allOptions;
    Button postbtn;
    private static final String TAG = "TargetFilterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_filter);

        compEng    = findViewById((R.id.checkboxcse));
        civilEng   = findViewById((R.id.checkboxcivileng));
        mechEng    = findViewById((R.id.checkboxmecheng));
        electEng   = findViewById((R.id.checkboxelecteng));
        allOptions = findViewById((R.id.checkboxall));

        postbtn = findViewById(btnpost);


        Button btn = findViewById(btnpost);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "Selected Department";
                if (compEng.isChecked()) {
                    result += "\ncomputer Eng.";
                }
                if (civilEng.isChecked()) {
                    result += "\ncivil Eng.";
                }
                if (mechEng.isChecked()) {
                    result += "\nMechanical Eng.";
                }
                if (electEng.isChecked()) {
                    result += "\nElectrical Eng.";
                }
                if (allOptions.isChecked()) {
                    result += "\nAll options Above";
                }
                Toast.makeText(getApplicationContext(), result, LENGTH_SHORT).show();
                Intent intent = new Intent(TargetFilterActivity.this,Main_Menue_Activity.class);
                startActivity(intent);

            }
        });


        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TargetFilterActivity.this , "Post done" , Toast.LENGTH_LONG).show();
                Log.d(TAG, "onClick: Post butoon is clicked");
                startActivity(new Intent(TargetFilterActivity.this, Main_Menue_Activity.class));
                Log.d(TAG, "onClick: going to Main_Menue_Activity.class");
            }
        });

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str = "";
        switch (view.getId()) {
            case R.id.checkboxcse:
                str = checked ? "CSE Selected" : "CSE Deselected";
                break;
            case R.id.checkboxcivileng:
                str = checked ? "Civil Eng. Selected" : "Civil Eng. Deselected";
                break;
            case R.id.checkboxmecheng:
                str = checked ? "Mechanical Eng. Selected" : "Mechanical Eng. Deselected";
                break;
            case R.id.checkboxelecteng:
                str = checked ? "Electrical Eng. Selected" : "Electrical Eng. Deselected";
                break;
            case R.id.checkboxall:
                str = checked ? "All department Selected" : "No department selected";
                break;
        }
        Toast.makeText(getApplicationContext(), str, LENGTH_SHORT).show();

    }


}
package com.example.finalopinionbox;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_SHORT;

public class AddPollOptionActivity extends AppCompatActivity {

    private static final String TAG = "AddPollOptionActivity";


    private EditText postText;

    private EditText op1;
    private EditText op2;
    private EditText op3;
    private EditText op4;
    private Button btnAddRow;

    DatabaseReference reff;
    Petition petition;
    Button btnnxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_add_poll_option);

        postText =   findViewById(R.id.posttxt);
        op1 =  findViewById(R.id.option1);
        op2 =  findViewById(R.id.option2);
        op3 =  findViewById(R.id.option3);
        op4 =  findViewById(R.id.option4);
        btnAddRow =  findViewById(R.id.btnaddrow);
        petition=new Petition();
        btnnxt=(Button)findViewById(R.id.btnnext);
        btnnxt.setEnabled(false);
        reff= FirebaseDatabase.getInstance().getReference().child("Petition");


        btnnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                petition.setPostText(postText.getText().toString().trim());
                petition.setOp1(op1.getText().toString().trim());
                petition.setOp2(op2.getText().toString().trim());
                /*For future references...
                petition.setOp3(op3.getText().toString().trim());
                petition.setOp4(op4.getText().toString().trim());
                */
                reff.push().setValue(petition);
                Toast.makeText(getApplicationContext(), " Data added succesfully ", LENGTH_SHORT).show();

                Intent intent = new Intent(AddPollOptionActivity.this,TargetFilterActivity.class);
                startActivity(intent);

            }


        });

        // To Choose of anonimity of the user.
        Spinner spinner;
        spinner = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(AddPollOptionActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Privacy));

        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        //Setting the editibility of the option adding
        op2.setEnabled(false);
        op3.setEnabled(false);
        op4.setEnabled(false);

        //Adding functionality for the view of the opition
        optionFunctionality();

    }

    //functionality of add row button
    public void addnewoption(View view) {

        op3.setVisibility(View.VISIBLE);
        btnAddRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op4.setVisibility(View.VISIBLE);
            }
        });
    }

    //Adding functionality for the view of the opition
    public void optionFunctionality() {
        op1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals(" ")) {
                    op2.setEnabled(false);//if option 1 is empty then option 2 is uneditable.
                } else {
                    op2.setEnabled(true);//if option 1 is not empty then option 2 is editable.
                    Log.d(TAG, "onTextChanged: option 2 is editable.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        op2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals(" ")) {
                    op3.setEnabled(false);//if option 2 is empty then option 3 is uneditable.
                    btnnxt.setEnabled(false); //if option 2 is empty then next button will not be enabled
                } else {
                    btnnxt.setEnabled(true);
                    op3.setEnabled(true);//if option 2 is not empty then option 3 is editable.
                    Log.d(TAG, "onTextChanged: option 3 is editable.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        op3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().equals(" ")) {
                    op4.setEnabled(false);//if option 3 is empty then option 4 is uneditable.
                } else {
                    op4.setEnabled(true);//if option 3 is not empty then option 4 is editable.
                    Log.d(TAG, "onTextChanged: option 4 is editable.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void goToTargetFilter(View view) {
        startActivity(new Intent(AddPollOptionActivity.this ,
                TargetFilterActivity.class));
        Log.d(TAG, "goToTargetFilter: Going to AddPollOptionActivity.class");
    }
}

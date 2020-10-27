package com.example.finalopinionbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PostMainActivity extends AppCompatActivity {

    RecyclerView recview;
    myAdapter adapter;

    SeekBar seekbar1, seekbar2;
    TextView op1, op2;
    TextView tvpercent1, tvpercent2;
    double count1 = 1, count2 = 1;
    boolean flag1 = true, flag2 = true;

    DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
    DatabaseReference ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_main);

        recview = (RecyclerView) findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(ref1.child("Petition"), model.class)
                        .build();

        adapter = new myAdapter(options);
        recview.setAdapter(adapter);

        seekbar1 = findViewById(R.id.seek_bar1);
        seekbar2 = findViewById(R.id.seek_bar2);

        op1 = findViewById(R.id.poll_option1);
        op2 = findViewById(R.id.poll_option2);

        tvpercent1 = findViewById(R.id.poll_percent1);
        tvpercent2 = findViewById(R.id.poll_percent2);

        ref2 = ref1.child("Petition");

        ref2.addValueEventListener(new ValueEventListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dsp:snapshot.getChildren())
                {
                    try{
                        seekbar1.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                return true;
                            }
                        });

                        op1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //check condition
                                if (flag1) //when flag1 is true
                                {
                                    count1++;
                                    count2 = 1;

                                    flag1 = false;
                                    flag2 = true;

                                    //calculate percentage
                                    calculatePercentage();
                                }
                            }
                        });

                        seekbar2.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                return true;
                            }
                        });

                        op2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //check condition
                                if(flag2) //when flag2 is true
                                {
                                    count1 = 1;
                                    count2++;

                                    flag1 = true;
                                    flag2 = false;

                                    //calculate percentage
                                    calculatePercentage();
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    @SuppressLint("DefaultLocale")
    public void calculatePercentage()
    {
        //calculate total
        double total = count1 + count2 ;
        //calculate percentage for all option
        double percent1 = (total/count1)*100;
        double percent2 = (total/count2)*100;

        //set percent on textview
        tvpercent1.setText(String.format("%.0f%%",percent1));
        //set progress on seekbar
        seekbar1.setProgress((int) percent1);
        tvpercent2.setText(String.format("%.0f%%",percent2));
        seekbar2.setProgress((int) percent2);


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
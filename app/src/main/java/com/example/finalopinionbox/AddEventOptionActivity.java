package com.example.finalopinionbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddEventOptionActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private static final String TAG = "activity_add_event_option";

    private EditText eventNameEt;
    private EditText topicEt;
    private EditText dateEt;
    private EditText venueEt;
    private EditText eventByEt;

    private final  String event_topic = "event_topic";
    private final  String event_date = "event_date";
    private final  String event_location = "event_location";
    private final  String event_name = "event_name";
    private final  String event_org = "event_org";

    LoginActivity x = new LoginActivity();

    public String y = x.dbName;

    DatabaseReference reff;
    Event event;
    Button btnpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_option);

        eventNameEt = findViewById(R.id.texteventname);
        topicEt = findViewById(R.id.texttopic);
        dateEt = findViewById(R.id.textdate);
        venueEt = findViewById(R.id.textvenue);
        eventByEt = findViewById(R.id.texteventby);

        event = new Event();

        btnpost=(Button)findViewById(R.id.btnpostevent);

        reff= FirebaseDatabase.
                getInstance()
                .getReference()
                .child("Event");


        event.setEventName(eventNameEt.getText().toString().trim());
        event.setTopic(topicEt.getText().toString().trim());
        event.setDate(dateEt.getText().toString().trim());
        event.setVenue(venueEt.getText().toString().trim());
        event.setEventBy(eventByEt.getText().toString().trim());
        reff.push().setValue(event);
        Toast.makeText(getApplicationContext(),"Data added successfully",Toast.LENGTH_SHORT).show();
    }

//    private void creatUser() {
//
//        // Create a new user with a first and last name
//        Map<String, Object> user = new HashMap<>();
//        user.put(event_name, eventNameEt
//                .getText()
//                .toString()
//                .trim());
//
//        user.put(event_location, venueEt
//                .getText()
//                .toString()
//                .trim());
//
//        user.put(event_org, eventByEt
//                .getText()
//                .toString()
//                .trim());
//        user.put(event_topic,topicEt.getText().toString().trim());

// Add a new document with a generated ID
//        db.collection("/Users/" + y + "/Event/Event1")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                        Toast.makeText(getApplicationContext(),"Data added successfully",Toast.LENGTH_SHORT).show();
////                        startActivity(new Intent(AddEventOptionActivity.this, Mai.class));
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                        Toast.makeText(getApplicationContext(),"Data Not successfully added",Toast.LENGTH_SHORT).show();
//                    }
//                });

        /* FOR GENERATING QUERY IN THIS BELOW QUERY IT
        CHECKS ALL FIELD NAME = "isAvailable" AND ITS
        VALUE TRUE IN EVERY DOCUMENT INSIDE
        COLLECTION = /Users/Divyam/Event  */

//        db.collection("/Users/Divyam/Event")
//                .whereEqualTo("isAvailable" , true )
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                        for (DocumentSnapshot snapshot : snapshotList){
//                            Log.d(TAG, "onSuccess: " + snapshot.getData().toString());
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.e(TAG, "onFailure: ", e );;
//
//                    }
//                });


        /* FOR ACCESING INDIVIDUAL DOCUMENT =Event1
        OF PATH = /Users/Divyam/Event  AND  DOCUMMENT
        INNSIDE COLLECTION = Event  */


//        final Task<DocumentSnapshot> documentSnapshotTask = db.collection("/Users/" + y + "/Event/Event1")
//                .document("Event1")
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        Log.d(TAG, "onSuccess: " + documentSnapshot.getData());
//                        Log.d(TAG, "onSuccess: " + documentSnapshot.getString("name"));
//                        Log.d(TAG, "onSuccess: " + documentSnapshot.getDouble("price"));
//                        Log.d(TAG, "onSuccess: " + documentSnapshot.getBoolean("isAvailable"));
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.e(TAG, "onFailure: ", e);
//                    }
//                });

        /* GENERATING QUERY TO ARRANGE VALUE OF
         PRICE */

//        db.collection("/Users/Divyam/Event")
//                .orderBy("price")
//                .orderBy( "price" , Query.Direction.DESCENDING)
//                .orderBy( "price" , Query.Direction.ASCENDING)
//                .limit( 3 )
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                        for (DocumentSnapshot snapshot : snapshotList){
//                            Log.d(TAG, "onSuccess: " + snapshot.getData());
//                            Toast.makeText(getApplicationContext() ," fkrmmmf" , Toast.LENGTH_LONG).show();
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.e(TAG, "onFailure: ", e );
//            }
//        });

//        db.collection("/Users/Divyam/Event")
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                    }
//                });
//    }


//    public void postevent(View view) {
////        creatUser();
////        /* POOJAN WORK FOR TESING REALTIME DB*/
//
////        event.setEventName(eventNameEt.getText().toString().trim());
////        event.setTopic(topicEt.getText().toString().trim());
////        event.setDate(dateEt.getText().toString().trim());
////        event.setVenue(venueEt.getText().toString().trim());
////        event.setEventBy(eventByEt.getText().toString().trim());
////        reff.push().setValue(event);
////        Toast.makeText(getApplicationContext(),"Data added successfully",Toast.LENGTH_SHORT).show();
//
//    }

}

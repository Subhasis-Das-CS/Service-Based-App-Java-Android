package com.esoft.subhasis.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class PayZone extends AppCompatActivity {

TextView payername;
Button paynow;
FirebaseAuth firebaseAuth;
FirebaseFirestore firebaseFirestore;
String uid, name;

Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_zone);
        toolbar=findViewById(R.id.toolbar12);
        toolbar.setTitle("Online Fees Payment");
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        uid=firebaseAuth.getCurrentUser().getUid();

        payername=findViewById(R.id.showpayername);
        paynow=findViewById(R.id.paynow);

        DocumentReference documentReference = firebaseFirestore.collection("users").document(uid);
        documentReference.addSnapshotListener(this,
                new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                        name = documentSnapshot.getString("fName");
                        Log.d("NAME", name);
                        payername.setText("Hello! "+name);


                    }
                });




    }
}
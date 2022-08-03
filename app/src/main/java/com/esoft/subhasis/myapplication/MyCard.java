package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Map;

public class MyCard extends AppCompatActivity {
    TextView name, barcode, cardtype, date;
    Button fetch, show;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseFirestore firebaseFirestore;
    String userid, phone="", toname="", tocode="", tocardtype="", todate="";
    ProgressDialog progressDialog;
    Object nameobj="", codeobj="", dateobj="", cardtypeobj="";
    ProgressBar progressBar;
    Map<String, Object> map;
    Toolbar toolbar;
    Button apply;
    String aaddress="",aname="", aemail="";
    DatabaseReference uploadreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_card);

        toolbar=findViewById(R.id.toolbar10);
        toolbar.setTitle("Virtual Card");
        uploadreference=FirebaseDatabase.getInstance().getReference("cardrequests");

        apply=findViewById(R.id.cardapply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=uploadreference.push().getKey();

                CardApply verifyUpload=new CardApply(aname, phone, aaddress, aemail);

                uploadreference.child(id).setValue(verifyUpload).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "Thank You For Applying", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        fetch = findViewById(R.id.fetch);
        fetch.setVisibility(View.VISIBLE);
        show = findViewById(R.id.show);
        show.setVisibility(View.INVISIBLE);
        name = findViewById(R.id.showcardname);
        barcode = findViewById(R.id.showbarcode);
        cardtype = findViewById(R.id.showcardtype);
        date = findViewById(R.id.showcarddate);
        progressBar = findViewById(R.id.progressBar2);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();

        userid = firebaseAuth.getCurrentUser().getUid();
        DocumentReference documentReference = firebaseFirestore.collection("users").document(userid);
        documentReference.addSnapshotListener(this,
                new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                        phone = documentSnapshot.getString("phone");
                        aaddress=documentSnapshot.getString("address");
                        aemail=documentSnapshot.getString("email");
                        aname=documentSnapshot.getString("fName");



                    }
                });


        ProgressDialog dialog = new ProgressDialog(MyCard.this);
        dialog.setMessage("Please Wait While Your Card Loads");
        dialog.setCancelable(false);
        dialog.setInverseBackgroundForced(false);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Here you can send the extras.
                dialog.dismiss();

                // close this activity

            }
        }, 8000);


        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("users").orderByChild("phone").equalTo(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                            String key = childSnapshot.getKey();
                            Map<String, Object> map = (Map<String, Object>) childSnapshot.getValue();
                            nameobj = map.get("name");
                            codeobj = map.get("barcode");
                            dateobj = map.get("cardexpirydate");
                            cardtypeobj = map.get("validity");
                        }
                        toname = nameobj.toString();
                        tocardtype = cardtypeobj.toString();
                        tocode = codeobj.toString();
                        todate = dateobj.toString();
                        Log.d("TAG", toname);
                        name.setText(toname);
                        barcode.setText(tocode);
                        date.setText(todate);
                        cardtype.setText(tocardtype);
                       /* progressDialog = new ProgressDialog(MyCard.this);
                        progressDialog.setTitle("Please Wait");
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressDialog.setIndeterminate(true);
                        progressDialog.setProgress(0);
                        progressDialog.setMax(100);
                        progressDialog.show();
                        final int totalProgressTime = 100;
                        final Thread t = new Thread() {
                            @Override
                            public void run() {
                                int jumpTime = 50;

                                while (jumpTime < totalProgressTime) {
                                    try {
                                        sleep(10000);
                                        jumpTime += 50;
                                        progressDialog.setProgress(jumpTime);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                        t.start(); */
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

              /*  show.postDelayed(new Runnable() {
                    public void run() {
                        progressDialog.dismiss();
                        show.setVisibility(View.VISIBLE);
                        fetch.setVisibility(View.INVISIBLE);
                    }
                }, 10000);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(toname);
                barcode.setText(tocode);
                date.setText(todate);
                cardtype.setText(tocardtype);

                progressBar.setVisibility(View.GONE);

            }
        });*/


            }


        });


    }
}


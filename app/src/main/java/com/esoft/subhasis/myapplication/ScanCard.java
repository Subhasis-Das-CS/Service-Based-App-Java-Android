package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.Map;

public class ScanCard extends AppCompatActivity {
Button scan, scan2, verify;
String code="";
FirebaseAuth firebaseAuth;
FirebaseFirestore firebaseFirestore;

String uid;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
ProgressDialog progressDialog;
TextView name, barcode, expirydate, status;
Object nameobj, codeobj, dateobj, cardtypeobj, validity;
String tocardtype, todate, toname, tocode, tovalidity;
DatabaseReference uploadreference;
String username="", phone="", email="", address="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_card);
        verify=findViewById(R.id.verify);
        name=findViewById(R.id.showbarcodename);
        barcode=findViewById(R.id.showbarcodecode);
        expirydate=findViewById(R.id.showbardcodeexpirydate);
        status=findViewById(R.id.showbarcodestatus);

        scan=findViewById(R.id.showscanneddata);
        scan2=findViewById(R.id.showscanneddata2);

        code=getIntent().getStringExtra("code");
        uploadreference=FirebaseDatabase.getInstance().getReference("sales");
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();
        DocumentReference documentReference = firebaseFirestore.collection("users").document(uid);
        documentReference.addSnapshotListener(this,
                new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                        phone = documentSnapshot.getString("phone");
                        email=documentSnapshot.getString("email");
                        address=documentSnapshot.getString("address");
                        username=documentSnapshot.getString("fName");



                    }
                });





        ProgressDialog dialog=new ProgressDialog(ScanCard.this);
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
        }, 7000);





        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("users").orderByChild("barcode").equalTo(code).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                            String key = childSnapshot.getKey();
                            Map<String, Object> map = (Map<String, Object>) childSnapshot.getValue();
                            nameobj = map.get("name");
                            codeobj = map.get("barcode");
                            dateobj = map.get("cardexpirydate");
                            cardtypeobj = map.get("cardtype");
                            validity = map.get("validity");
                        }
                        toname = nameobj.toString();
                        tocardtype = cardtypeobj.toString();
                        tocode = codeobj.toString();
                        todate = dateobj.toString();
                        tovalidity = validity.toString();
                        Log.d("Inside Data Change", toname);
                        Log.d("Inside Data Change", tocardtype);
                        Log.d("Inside Data Change",tocode);
                        Log.d("Inside Data Change", todate);
                        Log.d("Inside Data Change", tovalidity);
                        name.setText("Name: " + toname);
                        expirydate.setText("Expiry Date: " + todate);
                        status.setText("Status: " + tovalidity);
                        barcode.setText("ID: " + code);

                        if(status.getText().toString().equalsIgnoreCase("status: valid")){
                            status.setTextColor(Color.parseColor("#009650"));
                        }
                        if(status.getText().toString().equalsIgnoreCase("status: invalid")){
                            status.setTextColor(Color.RED);
                        }

                        name.setVisibility(View.VISIBLE);
                        expirydate.setVisibility(View.VISIBLE);
                        status.setVisibility(View.VISIBLE);
                        barcode.setVisibility(View.VISIBLE);

                        verify.setVisibility(View.VISIBLE);
                      /*  progressDialog = new ProgressDialog(ScanCard.this);
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
                                        sleep(8000);
                                        jumpTime += 50;
                                        progressDialog.setProgress(jumpTime);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                        t.start();*/

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }

        });


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=uploadreference.push().getKey();

                VerifyUpload verifyUpload=new VerifyUpload(username, address, phone, email, toname, code, tocardtype, tovalidity);

               uploadreference.child(id).setValue(verifyUpload).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void unused) {
                       Toast.makeText(getApplicationContext(), "Verified", Toast.LENGTH_SHORT).show();
                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });

            }
        });
    }
}
                    /*   scan2.postDelayed(new Runnable() {
                    public void run() {
                        progressDialog.dismiss();
                       scan2.setVisibility(View.VISIBLE);
                        scan.setVisibility(View.INVISIBLE);
                    }
                }, 10000);
            }

            });


scan2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        name.setText("Name: "+toname);
        expirydate.setText("Expiry Date: "+todate);
        status.setText("Status: "+tovalidity);
        barcode.setText("ID: "+code);
    }
});*/

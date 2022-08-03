package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import  com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanBarCode extends AppCompatActivity{
Button button, issue,renew,invalidiate, delete, cardpanel;
TextView showcode;
String code;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
FirebaseAuth firebaseAuth;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_bar_code);
        toolbar=findViewById(R.id.toolbar6);
        toolbar.setTitle("Card Admin");
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();
        cardpanel=findViewById(R.id.cardpanel);
        cardpanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent panel=new Intent(ScanBarCode.this, CardPanel.class);
                startActivity(panel);
            }
        });
        issue=findViewById(R.id.issuenewcard);
        issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ScanBarCode.this, issueCard.class);
                i.putExtra("code",code);
                startActivity(i);
            }
        });

        renew=findViewById(R.id.renewacard);
        renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScanBarCode.this, RenewCard.class);
                intent.putExtra("code", code);
                startActivity(intent);

            }
        });
        invalidiate=findViewById(R.id.invalidiateacard);
        invalidiate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.child("users").orderByChild("barcode").equalTo(code).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot childSnapshot: snapshot.getChildren()) {
                            String key = childSnapshot.getKey();
                            databaseReference.child("users").child(key).child("validity").setValue("Invalid").addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "This Card is Now Invalid", Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Card Not Found", Toast.LENGTH_LONG).show();
                                }
                            });

                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                    ;});
            }
        });
        delete=findViewById(R.id.deleteacard);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.child("users").orderByChild("barcode").equalTo(code).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot childSnapshot: snapshot.getChildren()) {
                            String key = childSnapshot.getKey();
                            databaseReference.child("users").child(key).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "Card Deleted", Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Card Not Found", Toast.LENGTH_LONG).show();
                                }
                            });

                    }


                }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                    ;});


            }
        });
        showcode=findViewById(R.id.showcode);
        button=findViewById(R.id.Scan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }
        });



    }

    private void scan() {
        IntentIntegrator intentIntegrator=new IntentIntegrator(this);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setCaptureActivity(Capture.class);
        intentIntegrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        code=intentResult.getContents().toString();
        showcode.setText(code);
        issue.setVisibility(View.VISIBLE);
        renew.setVisibility(View.VISIBLE);
        invalidiate.setVisibility(View.VISIBLE);
        delete.setVisibility(View.VISIBLE);
        if(intentResult !=null){
            AlertDialog.Builder builder=new AlertDialog.Builder(ScanBarCode.this);
            builder.setTitle("");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });
            builder.show();
        }else{

        }

    }
}
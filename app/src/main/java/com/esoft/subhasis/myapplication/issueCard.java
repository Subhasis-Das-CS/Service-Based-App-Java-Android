package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class issueCard extends AppCompatActivity {

    Button takepicture, ConfirmAndIssue;
    EditText name, phone, email, address, cardtype, expirydate;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String uid;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_card);

        name=findViewById(R.id.issuename);
        phone=findViewById(R.id.issuephone);
        email=findViewById(R.id.issueemail);
        address=findViewById(R.id.issueaddress);
        cardtype=findViewById(R.id.issuecardtype);
        expirydate=findViewById(R.id.issuecardexpirydate);
        toolbar=findViewById(R.id.toolbar7);
        toolbar.setTitle(getIntent().getStringExtra("code"));

        ConfirmAndIssue=findViewById(R.id.confirmandissue);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();


        databaseReference=FirebaseDatabase.getInstance().getReference("users");





        ConfirmAndIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString();
                String Phone="+91"+phone.getText().toString();
                String Email=email.getText().toString();
                String Address=address.getText().toString();
                String CardType=cardtype.getText().toString();
                String ExpiryDate=expirydate.getText().toString();
                String Validity="Valid";
                String code=getIntent().getStringExtra("code");
                String id= databaseReference.push().getKey();
                Card card=new Card(Name,Phone,Email,Address,CardType,ExpiryDate, Validity, code);
                databaseReference.child(id).setValue(card).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "Card Issued", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        phone.setText("");
                        email.setText("");
                        address.setText("");
                        cardtype.setText("");
                        expirydate.setText("");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Card Issue Failed", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
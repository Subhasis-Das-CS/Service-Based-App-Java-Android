package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddDetails extends AppCompatActivity {


    EditText name, phone, email, address;
    Button button;
    ProgressBar addprogress;
    String uid;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        name=findViewById(R.id.addname);
        phone=findViewById(R.id.addPhone);
        email=findViewById(R.id.addEmail);
        address=findViewById(R.id.addAddress);
        button=findViewById(R.id.addSubmit);
        addprogress=findViewById(R.id.progressBar2add);
        phone.setText(getIntent().getStringExtra("phone"));
        phone.setFocusable(false);
        phone.setEnabled(false);
        phone.setCursorVisible(false);
        phone.setKeyListener(null);
        addprogress.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addprogress.setVisibility(View.VISIBLE);
                final String uemail = email.getText().toString().trim();
                final String fullname = name.getText().toString().trim();

                final String uaddress = address.getText().toString().trim();
                final String addphone=getIntent().getStringExtra("phone");

                uid=firebaseAuth.getCurrentUser().getUid();

                DocumentReference documentReference = firebaseFirestore.collection("users").document(uid);
                Map<String,Object> user = new HashMap<>();
                user.put("fName",fullname);
                user.put("email",uemail);
                user.put("phone",addphone);
                user.put("address",uaddress);

                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        addprogress.setVisibility(View.GONE);
                       // Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                        //Log.d(TAG, "onFailure: " + e.toString());
                    }
                });
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });






}



}

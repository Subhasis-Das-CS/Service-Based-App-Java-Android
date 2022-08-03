package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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

public class Register extends AppCompatActivity {

    EditText name, email, phone, password, address;
    Button button;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String uid;
    TextView already;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar=findViewById(R.id.progressBar3);
      progressBar.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);
        already=findViewById(R.id.already);
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent al=new Intent(Register.this, LoginTwo.class);
                startActivity(al);
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        name=findViewById(R.id.signupname);
        email=findViewById(R.id.signupemailid);
        phone=findViewById(R.id.signupphone);
        password=findViewById(R.id.signuppassword);
        address=findViewById(R.id.signupaddress);
        button=findViewById(R.id.submit);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressBar.setVisibility(View.VISIBLE);
                        final String uemail= email.getText().toString().trim();
                        final String upassword=password.getText().toString().trim();
                        final String fullname= name.getText().toString().trim();
                        final String uphone="+91"+phone.getText().toString().trim();
                        final String uaddress=address.getText().toString().trim();


                        firebaseAuth.createUserWithEmailAndPassword(uemail,upassword).addOnCompleteListener(
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();

                                            uid = firebaseAuth.getCurrentUser().getUid();
                                            DocumentReference documentReference = firebaseFirestore.collection("users").document(uid);
                                            Map<String,Object> user = new HashMap<>();
                                            user.put("fName",fullname);
                                            user.put("email",uemail);
                                            user.put("phone",uphone);
                                            user.put("pwd",upassword);
                                            user.put("address",uaddress);
                                            documentReference.set(user).addOnSuccessListener(
                                                    new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void aVoid) {
                                                        progressBar.setVisibility(View.GONE);
                                                       Toast.makeText(Register.this, "DONE", Toast.LENGTH_LONG).show();
                                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                                        }
                                                    }).addOnFailureListener(
                                                    new OnFailureListener() {


                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                                progressBar.setVisibility(View.GONE);
                                                        }
                                                    });


                                        } else {
                                            progressBar.setVisibility(View.INVISIBLE);
                                            Toast.makeText(Register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                                        }
                                    }
                                } );



                    }
                }

        );


    }
}
package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {
FirebaseAuth firebaseAuth;
    public static final String TAG = "TAG";

TextView loginusingemailandpassword;
    ProgressBar progressBar;

        ProgressDialog pd;

EditText loginPhone;
Button loginButton, loginButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginusingemailandpassword=findViewById(R.id.loginusingemailandpassword);

        loginusingemailandpassword.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                startActivity(new Intent(Login.this, LoginTwo.class));
            }
        });


        firebaseAuth=FirebaseAuth.getInstance();

        loginPhone=findViewById(R.id.loginPhone);
        loginButton=findViewById(R.id.loginButton);
        progressBar=findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(loginPhone.getText().toString().length()>10){
                    loginPhone.setError("Must Be 10 Digits");
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    String phone = "+91" + loginPhone.getText().toString();
                    if (loginPhone.getText().toString().isEmpty()) {
                        loginPhone.setError("Please Enter Phone No.");
                    } else {
                        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone, 60, TimeUnit.SECONDS, Login.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        String code = phoneAuthCredential.getSmsCode();

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        Intent intent = new Intent(getApplicationContext(), verifyOtp.class);
                                        intent.putExtra("phone", phone);
                                        intent.putExtra("verificationId", s);


                                        startActivity(intent);
                                    }
                                });


                    }
                }
            }
        });

    }



}

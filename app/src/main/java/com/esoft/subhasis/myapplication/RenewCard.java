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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RenewCard extends AppCompatActivity {
Toolbar toolbar;
String code;
EditText date;
Button renew;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renew_card);

        toolbar=findViewById(R.id.toolbar8);

        code=getIntent().getStringExtra("code");
        toolbar.setTitle(code);
        date=findViewById(R.id.enternewexpirydate);
        renew=findViewById(R.id.updateexpirydate);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();

    renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Date=date.getText().toString();
                databaseReference.child("users").orderByChild("barcode").equalTo(code).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot childSnapshot: snapshot.getChildren()) {
                            String key = childSnapshot.getKey();
                            databaseReference.child("users").child(key).child("cardexpirydate").setValue(Date).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "Card Renewed", Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Card Not Found", Toast.LENGTH_LONG).show();
                                }
                            });

                            databaseReference.child("users").child(key).child("validity").setValue("Valid");

                        }
        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
    });
}
    });
    }
}
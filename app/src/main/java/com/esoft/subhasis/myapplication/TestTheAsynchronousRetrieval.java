package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class TestTheAsynchronousRetrieval extends AppCompatActivity {

    ArrayList<String>list;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference itemreference;
    Object nameobj, codeobj, dateobj, cardtypeobj;
    Button button;
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_the_asynchronous_retrieval);
        button=findViewById(R.id.button3);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference();

Log.d("Before", "Attaching Listener");
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              databaseReference.child("users").orderByChild("phone").equalTo("+917450935104").addListenerForSingleValueEvent(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot snapshot) {

                      for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                          String key = childSnapshot.getKey();
                          Map<String, Object> map = (Map<String, Object>) childSnapshot.getValue();
                          nameobj = map.get("name");
                          codeobj = map.get("barcode");
                          dateobj = map.get("cardexpirydate");
                          cardtypeobj = map.get("cardtype");
                      }
                         name=nameobj.toString();
                      Log.d("Inside DATA cHANGE", name);
                      button.setText(name);

                  }


                  @Override
                  public void onCancelled(@NonNull DatabaseError error) {

                  }
              });

              Log.d("Out Side Date Change",name);
          }
      });



    }
}
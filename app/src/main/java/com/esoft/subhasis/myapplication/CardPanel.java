package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CardPanel extends AppCompatActivity {
RecyclerView recyclerView;
Toolbar toolbar;
CardAdapter cardAdapter;
ArrayList<Card> lists;
String name,email;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
EditText cardsearch;
    TextView test;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_panel);
        cardsearch=findViewById(R.id.cardsearch);
        toolbar=findViewById(R.id.toolbar9);
        toolbar.setTitle("Card List");
        recyclerView=findViewById(R.id.allcardshere);
        test=findViewById(R.id.testing);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();

        ProgressDialog dialog=new ProgressDialog(CardPanel.this);
        dialog.setMessage("Please Wait While Your Card Panel Loads");
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
        }, 4000);




        recyclerView.setHasFixedSize(true);


        lists = new ArrayList<>();


test.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        callcards();

    }
});


cardsearch.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        filter(s.toString());
    }
});


    }

    public void callcards(){


      databaseReference.child("users").orderByChild("barcode").addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot snapshot) {
              for(DataSnapshot ds: snapshot.getChildren()){

                 Card c=ds.getValue(Card.class);
                 lists.add(c);
              }
              recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
              cardAdapter=new CardAdapter(getApplicationContext(),lists);
              recyclerView.setAdapter(cardAdapter);

          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });

    }

    void filter(String text) {
        ArrayList<Card> temp = new ArrayList();
        for (Card d : lists) {

            if (d.getValidity().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);

            }
            //update recyclerview

            cardAdapter.updateList(temp);
        }
    }
}
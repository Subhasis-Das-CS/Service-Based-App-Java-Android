package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class Splash extends AppCompatActivity {
    ImageView imageView;
    Handler handler;
    FirebaseAuth firebaseAuth;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=findViewById(R.id.imageView);
        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(aniFade);
        firebaseAuth=FirebaseAuth.getInstance();
        textView=findViewById(R.id.aroseunited);
        textView.setAnimation(aniFade);


        if(firebaseAuth.getCurrentUser()!=null){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        }


        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {

                    startActivity(new Intent(getApplicationContext(), Register.class));

                }


            }
        },2500);









    }
}
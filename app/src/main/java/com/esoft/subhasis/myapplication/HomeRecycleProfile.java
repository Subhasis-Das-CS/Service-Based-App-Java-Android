package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeRecycleProfile extends AppCompatActivity {

    CarouselView carouselView;
    ImageView imageView, call, sms, email;
    TextView textView1, textView2, textView3, largedatarecycle;
    Toolbar toolbar;
    String car1, car2, car3, text1, text2, text3, image, emails, largedata;
    String[] images={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_recycle_profile);
                toolbar=findViewById(R.id.toolbar4);
                largedatarecycle=findViewById(R.id.largedatarecycle);
                carouselView=findViewById(R.id.homerecyclecarousel);
                imageView=findViewById(R.id.homerecycleprofileimage);
                call=findViewById(R.id.homerecyclecall);
                sms=findViewById(R.id.homerecyclesms);
                email=findViewById(R.id.homerecycleemail);
                textView1=findViewById(R.id.homerecycletext1);
                textView2=findViewById(R.id.homerecycletext2);
                textView3=findViewById(R.id.homerecycletext3);

               car1=getIntent().getStringExtra("carousel1");
               car2=getIntent().getStringExtra("carousel2");
               car3=getIntent().getStringExtra("carousel3");
               text1=getIntent().getStringExtra("text1");
               text2=getIntent().getStringExtra("text2");
               text3=getIntent().getStringExtra("text3");
               image=getIntent().getStringExtra("image");
               emails=getIntent().getStringExtra("email");
               largedata=getIntent().getStringExtra("largedata");

               Picasso.with(HomeRecycleProfile.this).load(image).into(imageView);

               textView1.setText(text1);
               textView2.setText(text2);
               textView3.setText(text3);
               largedatarecycle.setText(largedata);

               images= new String[]{car1,car2,car3};
               carouselView.setPageCount(images.length);
               carouselView.setImageListener(imageListener);

               toolbar.setTitle(text1);
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent call =new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:"+text3));
                        startActivity(call);
                    }
                });
                sms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent sms=new Intent(Intent.ACTION_SENDTO);
                        sms.setData(Uri.parse("smsto:"+text3));
                        startActivity(sms);
                    }
                });

                email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent email=new Intent(Intent.ACTION_SENDTO);
                        email.setData(Uri.parse("mailto:"+emails));
                        startActivity(email);
                    }
                });



    }
    ImageListener imageListener =new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.with(getApplicationContext()).load(images[position]).networkPolicy(NetworkPolicy.NO_CACHE)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)

                    .into(imageView);

        }
    };





}
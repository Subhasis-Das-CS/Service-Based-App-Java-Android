package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Pages extends AppCompatActivity {


    String name, coverimage,experience, address, phone, largedata;
    ImageView imageView;
    TextView showname, showexperience,showaddress, showphone, showlargedata;
    Toolbar toolbar;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);
        showname=findViewById(R.id.showname);
        showaddress=findViewById(R.id.showaddress);
        imageView=findViewById(R.id.showcoverimage);
        showexperience=findViewById(R.id.showexperience);
        showphone=findViewById(R.id.pageshophone);
        call=findViewById(R.id.callnow);
        showlargedata=findViewById(R.id.largedata);

        phone=getIntent().getStringExtra("phno");
        name=getIntent().getStringExtra("name");
        coverimage=getIntent().getStringExtra("photo");
        address=getIntent().getStringExtra("address");
        experience=getIntent().getStringExtra("experience");
        largedata=getIntent().getStringExtra("largedata");

        showlargedata.setText(largedata);
        showphone.setText(phone);
        showname.setText(name);
        showaddress.setText(address);
        showexperience.setText(experience);
        toolbar=findViewById(R.id.toolbar3);
        toolbar.setTitle(name);

        Picasso.with(getApplicationContext()).load(coverimage).into(imageView);



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                String no=phone.substring(0,10);

                callIntent.setData(Uri.parse("tel:"+no));
                startActivity(callIntent);
            }
        });


    }
}
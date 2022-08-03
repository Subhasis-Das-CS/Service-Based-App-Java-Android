package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Shopitempage extends AppCompatActivity {

    TextView sellingprice, oldprice, discount, name,productdes;
    CarouselView carouselView;
    Button call, sms;

    String price, old, dis,namestring, phone, car1,car2, car3, productdescription, brand;
    Toolbar toolbar;
    String[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopitempage);
        productdes=findViewById(R.id.productdescription);

        name=findViewById(R.id.shopname);
        sellingprice = findViewById(R.id.shopsellingprice);
        oldprice = findViewById(R.id.shopoldprice);
        discount = findViewById(R.id.shopdiscount);
        carouselView = findViewById(R.id.shopcarousel);
        call = findViewById(R.id.shopcall);

        toolbar = findViewById(R.id.toolbar5);


        price = getIntent().getStringExtra("price");
        old = getIntent().getStringExtra("old");
        dis = getIntent().getStringExtra("dis");
        phone = getIntent().getStringExtra("phone");
        car1 = getIntent().getStringExtra("car1");
        car2 = getIntent().getStringExtra("car2");
        car3 = getIntent().getStringExtra("car3");
        namestring=getIntent().getStringExtra("name");
        productdescription=getIntent().getStringExtra("productdes");
        brand=getIntent().getStringExtra("brand");

        images = new String[]{car1, car2, car3};
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(imageListener);


        sellingprice.setText(price);
        oldprice.setText(old);
        oldprice.setPaintFlags(oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        discount.setText(dis);
        name.setText(namestring);
        toolbar.setTitle(namestring);
        productdes.setText(productdescription);


call.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent call=new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:"+phone));
        startActivity(call);
    }
});



    }

    ImageListener imageListener=new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.with(getApplicationContext()).load(images[position]).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView);
        }
    };
}
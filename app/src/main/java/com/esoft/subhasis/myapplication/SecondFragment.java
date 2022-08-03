package com.esoft.subhasis.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class SecondFragment extends Fragment {

    CarouselView carouselView;
    ImageView imageView;
    Button openwebsite, payyourfees;
    String[] images={"https://aroseunited.com/appimages/club/1.jpg",
            "https://aroseunited.com/appimages/club/2.jpg",
            "https://aroseunited.com/appimages/club/3.jpg",
            "https://aroseunited.com/appimages/club/4.jpg",
            "https://aroseunited.com/appimages/club/5.jpg"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        imageView=view.findViewById(R.id.match);

        Picasso.with(getContext()).load("https://aroseunited.com/appimages/club/match.jpg").networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://aroseunited.com/index.php/matches/")));
            }
        });

        carouselView=view.findViewById(R.id.club);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(imageListener);
        payyourfees=view.findViewById(R.id.pay);
        payyourfees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pay=new Intent(getContext(), PayZone.class);
                startActivity(pay);
            }
        });
        openwebsite=view.findViewById(R.id.gotoweb);
        openwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web=new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://aroseunited.com"));
                startActivity(web);
            }
        });
        return view;
    }

    ImageListener imageListener=new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.with(getContext()).load(images[position]).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(imageView);
        }
    };
}
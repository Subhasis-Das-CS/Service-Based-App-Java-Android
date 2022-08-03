package com.esoft.subhasis.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class firstFragment extends Fragment {
    List<HomeList> lists;
    String url;
    homerecycleadapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    TextView more;
    RecyclerView recyclerView;
    Handler handler = new Handler();
    Runnable refresh;
    private String[] sampleImages;
    ImageView imageView;
    CarouselView carouselView;
    Handler mHandler;
    ImageView doctor, education, sports, consultants, rent, homeservices, designing, repair, engineer, jobs, decorators, car;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first,container,false);
        sampleImages  = new String[]{"https://aroseunited.com/appresources/homecarousel/1.jpg",
                "https://aroseunited.com/appresources/homecarousel/2.jpg",
                "https://aroseunited.com/appresources/homecarousel/3.jpg",
                "https://aroseunited.com/appresources/homecarousel/4.jpg",
                "https://aroseunited.com/appresources/homecarousel/5.jpg",
                "https://aroseunited.com/appresources/homecarousel/1.jpg"};

        shimmerFrameLayout=view.findViewById(R.id.shimmerLayout3);
        shimmerFrameLayout.startShimmer();
        carouselView=view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(imageClickListener);
        education=view.findViewById(R.id.homeeducation);
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent education=new Intent(getContext(), AllOptions.class);
                education.putExtra("option", "education");
                startActivity(education);
            }
        });


        /*     engineer=view.findViewById(R.id.homeengineer);
        engineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent engineer=new Intent(getContext(), AllOptions.class);
                engineer.putExtra("option", "engineer");
                startActivity(engineer);
            }
        });
        jobs=view.findViewById(R.id.homejobs);
        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jobs=new Intent(getContext(), AllOptions.class);
                jobs.putExtra("option", "jobs");
                startActivity(jobs);
            }
        });
        decorators=view.findViewById(R.id.homedecorators);
        decorators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent decorators=new Intent(getContext(), AllOptions.class);
                decorators.putExtra("option", "decorators");
                startActivity(decorators);
            }
        });
        car=view.findViewById(R.id.homecarrent);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent car=new Intent(getContext(), AllOptions.class);
                car.putExtra("option", "car");
                startActivity(car);
            }
        });
*/
        sports=view.findViewById(R.id.homesports);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sports=new Intent(getContext(), AllOptions.class);
                sports.putExtra("option", "sports");
                startActivity(sports);
            }
        });
        consultants=view.findViewById(R.id.homeconsultant);
        consultants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consul=new Intent(getContext(), AllOptions.class);
                consul.putExtra("option", "consultants");
                startActivity(consul);
            }
        });
        rent=view.findViewById(R.id.homerent);
        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rent=new Intent(getContext(), AllOptions.class);
                rent.putExtra("option", "rent");
                startActivity(rent);
            }
        });
        homeservices=view.findViewById(R.id.homehomeservices);
        homeservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeservices=new Intent(getContext(), AllOptions.class);
                homeservices.putExtra("option", "homeservices");
                startActivity(homeservices);
            }
        });
        designing=view.findViewById(R.id.homeinterior);
        designing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent designing=new Intent(getContext(), AllOptions.class);
                designing.putExtra("option", "designing");
                startActivity(designing);
            }
        });
        repair=view.findViewById(R.id.polyclinic);
        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair=new Intent(getContext(), AllOptions.class);
                repair.putExtra("option", "medicalfacilities");
                startActivity(repair);
            }
        });




        doctor=view.findViewById(R.id.homedector);

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent doctor=new Intent(getContext(), AllOptions.class);
            doctor.putExtra("option", "doctor");
            startActivity(doctor);
            }
        });

        more=view.findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), MoreOptions.class);
                startActivity(i);
            }
        });

        url="https://aroseunited.com/appimages/homerecycle.json";
        lists=new ArrayList<>();

        recyclerView=view.findViewById(R.id.listt);


        extractrecycleview();

           return view;
    }

    private void extractrecycleview() {



            RequestQueue queue= Volley.newRequestQueue(getContext());
            JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject songObject = response.getJSONObject(i);

                            HomeList list = new HomeList();
                            list.setText(songObject.getString("data1"));
                            list.setImageurl(songObject.getString("image"));
                            list.setText1(songObject.getString("text1"));
                            list.setText2(songObject.getString("text2"));
                            list.setText3(songObject.getString("text3"));
                            list.setCarousel1(songObject.getString("carousel1"));
                            list.setCarousel2(songObject.getString("carousel2"));
                            list.setCarousel3(songObject.getString("carousel3"));
                            list.setEmail(songObject.getString("email"));
                            list.setLargedata(songObject.getString("largedata"));
                            lists.add(list);

                            recyclerView.setVisibility(View.VISIBLE);
                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
                    adapter= new homerecycleadapter(getContext(), lists);
                    recyclerView.setAdapter(adapter);


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Log.d("Error", error.getMessage());
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getContext(), MainActivity.class);
                    startActivity(i);

                }
            });

            queue.add(jsonArrayRequest);
        }



    ImageClickListener imageClickListener=new ImageClickListener() {
        @Override
        public void onClick(int position) {
            if(position==0){
                Toast.makeText(getContext(), "Click working 2", Toast.LENGTH_LONG).show();
            }
            if(position==1){
                Toast.makeText(getContext(), "Click working 2", Toast.LENGTH_LONG).show();
            }
            if(position==2){
                Toast.makeText(getContext(), "Click working 3", Toast.LENGTH_LONG).show();
            }
            if(position==3){
                Toast.makeText(getContext(), "Click working 4", Toast.LENGTH_LONG).show();
            }
            if(position==4){
                Toast.makeText(getContext(), "Click working 5", Toast.LENGTH_LONG).show();
            }
            if(position==5){
                Toast.makeText(getContext(), "Click workin 6", Toast.LENGTH_LONG).show();
            }

        }
    };

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {


            Picasso.with(getContext()).load(sampleImages[position]).networkPolicy(NetworkPolicy.NO_CACHE)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)

                    .into(imageView);
        }
    };


}
package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CurrentOffers extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ShimmerFrameLayout shimmerFrameLayout;
    List<offers> lists;
    offerAdapter adapter;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_offers);
        shimmerFrameLayout=findViewById(R.id.shimmerLayout22);
        shimmerFrameLayout.startShimmer();
        toolbar=findViewById(R.id.toolbar14);
        toolbar.setTitle("Current Offers");
        recyclerView=findViewById(R.id.offerrecycle);
        lists=new ArrayList<>();

        url="https://aroseunited.com/appjson/offers.json";
        extractrecycleview();

    }

    private void extractrecycleview() {



        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject songObject = response.getJSONObject(i);

                        offers list = new offers();
                       list.setImage1(songObject.getString("image1"));
                       list.setImage2(songObject.getString("image2"));
                       lists.add(list);


                        recyclerView.setVisibility(View.VISIBLE);
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
                adapter= new offerAdapter(getApplicationContext(), lists);
                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Log.d("Error", error.getMessage());
                Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(CurrentOffers.this, MainActivity.class);
                startActivity(i);
            }
        });

        queue.add(jsonArrayRequest);
    }


}
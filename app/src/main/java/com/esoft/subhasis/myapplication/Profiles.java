package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class Profiles extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Songs> songs;
    String filename;
    private String  url,category;
    Adaptar adaptar;
    EditText searchbox;
    ShimmerFrameLayout shimmerFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
        shimmerFrameLayout=findViewById(R.id.shimmerLayout2);
        shimmerFrameLayout.startShimmer();
        category=getIntent().getStringExtra("category");
        filename=getIntent().getStringExtra("url");
        url="https://aroseunited.com/appjson/"+filename+".json";

        extractSongs();
        searchbox=findViewById(R.id.searchbox);
        searchbox.addTextChangedListener(new TextWatcher() {
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
        recyclerView=findViewById(R.id.songsList);

        songs=new ArrayList<>();



    }

    void filter(String text){
        List<Songs> temp = new ArrayList();
        for(Songs d: songs){

            if(d.getTitle().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }else if(d.getArtist().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }else if(d.getPin().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview

        adaptar.updateList(temp);
    }

    private void extractSongs() {

        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject songObject = response.getJSONObject(i);

                        Songs song = new Songs();

                        song.setTitle(songObject.getString("data1"));
                        song.setArtist(songObject.getString("data2"));
                        song.setCoverImage(songObject.getString("image"));
                        song.setSongUrl(songObject.getString("data3"));
                        song.setPhno(songObject.getString("phone"));
                        song.setLargedata(songObject.getString("largedata"));
                        song.setPin(songObject.getString("pin"));
                        songs.add(song);
                        recyclerView.setVisibility(View.VISIBLE);
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adaptar=new Adaptar(getApplicationContext(), songs);
                recyclerView.setAdapter(adaptar);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Log.d("Error", error.getMessage());
                Toast.makeText(getApplicationContext(), "Not Available Yet", Toast.LENGTH_SHORT).show();
                Intent go=new Intent(Profiles.this, MainActivity.class);
                startActivity(go);

                }


        });

        queue.add(jsonArrayRequest);
    }
}

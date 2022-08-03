package com.esoft.subhasis.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class ThirdFragment extends Fragment {
    RecyclerView recyclerView;
    EditText search;
    List<ShopList> songs;
    String url;
    ShopAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        shimmerFrameLayout=view.findViewById(R.id.shimmerLayout);
        shimmerFrameLayout.startShimmer();


        recyclerView=view.findViewById(R.id.shoprecycle);
        search=view.findViewById(R.id.shopsearch);

        songs=new ArrayList<>();
        url="https://aroseunited.com/appjson/shop/shop.json";
        extractSongs();

        search.addTextChangedListener(new TextWatcher() {
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



        return view;
    }

    void filter(String text){
        List<ShopList> temp = new ArrayList();
        for(ShopList d: songs){

            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }else if(d.getBrand().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }else if(d.getCategory().contains(text)){
                temp.add(d);
            }else if(d.getColor().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview

        adapter.updateList(temp);
    }



    private void extractSongs() {

        RequestQueue queue= Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject songObject = response.getJSONObject(i);


                        ShopList song = new ShopList();
                        song.setName(songObject.getString("name"));
                        song.setImage(songObject.getString("image"));
                        song.setBrand(songObject.getString("brand"));
                        song.setPrice(songObject.getString("price"));
                        song.setCategory(songObject.getString("category"));
                        song.setColor(songObject.getString("color"));
                        song.setOldprice(songObject.getString("oldprice"));
                        song.setDiscount(songObject.getString("discount"));
                        song.setCar1(songObject.getString("car1"));
                        song.setCar2(songObject.getString("car2"));
                        song.setCar3(songObject.getString("car3"));
                        song.setPhone(songObject.getString("phone"));
                        song.setLargedata(songObject.getString("productdes"));


                        songs.add(song);
                    shimmerFrameLayout.stopShimmer();
                    recyclerView.setVisibility(View.VISIBLE);
                    shimmerFrameLayout.setVisibility(View.GONE);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter=new ShopAdapter(getContext(),songs );
                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Log.d("Error", " "+error.getMessage());

                Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        queue.add(jsonArrayRequest);
    }
}

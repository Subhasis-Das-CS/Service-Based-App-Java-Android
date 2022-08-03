package com.esoft.subhasis.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class offerAdapter extends RecyclerView.Adapter<offerAdapter.ViewHolder> {
    LayoutInflater inflater;

    Context ct;
    List<offers> songs;
    public offerAdapter (Context ct, List<offers> songs){

        this.inflater=LayoutInflater.from(ct);
        this.songs=songs;
        this.ct=ct;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.offerslayout,parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.with(inflater.getContext()).load(songs.get(position).getImage1()).into(holder.image1);
        Picasso.with(inflater.getContext()).load(songs.get(position).getImage2()).into(holder.image2);





    }



    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView image1, image2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image1=itemView.findViewById(R.id.offer1);
            image2=itemView.findViewById(R.id.offer2);


        }
    }

}


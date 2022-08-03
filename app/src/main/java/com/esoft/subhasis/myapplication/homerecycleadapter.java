package com.esoft.subhasis.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class homerecycleadapter extends RecyclerView.Adapter<homerecycleadapter.HorizontalViewHolder>{
    LayoutInflater inflater;

    Context ct;
    List<HomeList> songs;
    public homerecycleadapter(Context ct, List<HomeList> songs){
        this.inflater=LayoutInflater.from(ct);
        this.songs=songs;
        this.ct=ct;


    }

    public homerecycleadapter() {

    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.homerecyclelayout,parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {

        holder.textView.setText(songs.get(position).getText());
        Picasso.with(ct).load(songs.get(position).getImageurl()).into(holder.imageView);
        String text1=songs.get(position).getText1();
        String text2=songs.get(position).getText2();
        String text3=songs.get(position).getText3();
        String carousel1=songs.get(position).getCarousel1();
        String carousel2=songs.get(position).getCarousel2();
        String carousel3=songs.get(position).getCarousel3();
        String image=songs.get(position).getImageurl();
        String email=songs.get(position).getEmail();
        String largedata=songs.get(position).getLargedata();
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ct, HomeRecycleProfile.class);
                i.putExtra("text1", text1);
                i.putExtra("text2", text2);
                i.putExtra("text3", text3);
                i.putExtra("carousel1", carousel1);
                i.putExtra("carousel2", carousel2);
                i.putExtra("carousel3", carousel3);
                i.putExtra("email", email);
                i.putExtra("image", image);
                i.putExtra("largedata", largedata);

                ct.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.homerecycleimage);
            textView=itemView.findViewById(R.id.homerecycletext);

        }
    }
}

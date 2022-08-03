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

public class Adaptar extends RecyclerView.Adapter<Adaptar.ViewHolder> {
    LayoutInflater inflater;

    Context ct;
    List<Songs> songs;
    public Adaptar (Context ct, List<Songs> songs){

        this.inflater=LayoutInflater.from(ct);
         this.songs=songs;
this.ct=ct;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.custom_list_layout,parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.songTitle.setText(songs.get(position).getTitle());
        holder.songArtists.setText(songs.get(position).getArtist());
        holder.experience.setText(songs.get(position).getSongUrl());
        String name=songs.get(position).getTitle();
        String artist=songs.get(position).getArtist();
        String imageurl=songs.get(position).getCoverImage();
        String experience=songs.get(position).getSongUrl();
        String phno=songs.get(position).getPhno();
        String largedata=songs.get(position).getLargedata();
       Picasso.with(inflater.getContext()).load(songs.get(position).getCoverImage()).into(holder.songCoverImage);

       holder.explore.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(ct, Pages.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.putExtra("name", name);
               intent.putExtra("address", artist);
               intent.putExtra("photo", imageurl);
               intent.putExtra("experience", experience);
               intent.putExtra("phno", phno);
               intent.putExtra("largedata", largedata);
               ct.startActivity(intent);
           }
       });

      holder.songTitle.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(ct, Pages.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              intent.putExtra("name", name);
              intent.putExtra("address", artist);
              intent.putExtra("photo", imageurl);
              intent.putExtra("experience", experience);
              intent.putExtra("largedata", largedata);
              ct.startActivity(intent);
          }
      });


       holder.songCoverImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(ct, Pages.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.putExtra("name", name);
               intent.putExtra("address", artist);
               intent.putExtra("photo", imageurl);
               intent.putExtra("experience", experience);
               intent.putExtra("largedata", largedata);
               ct.startActivity(intent);




           }
       });

    }

    public void updateList(List<Songs> list){
        songs = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView songTitle, songArtists, experience;
        ImageView songCoverImage;
        Button explore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songArtists=itemView.findViewById(R.id.songArtist);
            songTitle=itemView.findViewById(R.id.songTitle);
            songCoverImage=itemView.findViewById(R.id.coverImage);
            experience=itemView.findViewById(R.id.experience);
            explore=itemView.findViewById(R.id.exploreto);



        }
    }

}

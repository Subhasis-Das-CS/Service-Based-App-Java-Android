package com.esoft.subhasis.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    Context context;

    ArrayList<Card> list;


    public CardAdapter(Context context, ArrayList<Card> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardlayout,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Card user = list.get(position);
        holder.name.setText("Name: "+user.getName());
        holder.email.setText("Email: "+user.getEmail());
        holder.status.setText("Status: "+user.getValidity());
        holder.phone.setText("Phone no: "+user.getPhone());
        holder.date.setText("Expiry Date: "+user.getCardexpirydate());
        holder.address.setText("Address: "+user.getAddress());

        String phonenumber=user.getPhone();
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call=new Intent(Intent.ACTION_DIAL);
                call.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                call.setData(Uri.parse("tel:"+ phonenumber));
                context.startActivity(call);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateList(ArrayList<Card> temp) {
        list=temp;
        notifyDataSetChanged();;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, email, phone, status, date,address;
        Button call;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.cardname);
            email = itemView.findViewById(R.id.cardemail);
            phone=itemView.findViewById(R.id.cardphonenumber);
            status = itemView.findViewById(R.id.cardstatus);
            date=itemView.findViewById(R.id.cardexpirydate);
            call=itemView.findViewById(R.id.cardcall);
            address=itemView.findViewById(R.id.cardaddress);


        }
    }

}
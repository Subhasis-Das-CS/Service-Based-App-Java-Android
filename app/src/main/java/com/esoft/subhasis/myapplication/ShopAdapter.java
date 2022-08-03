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

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    LayoutInflater inflater;

    Context ct;
    List<ShopList> shoplist;
    public ShopAdapter (Context ct, List<ShopList> shoplist){

        this.inflater=LayoutInflater.from(ct);
        this.shoplist=shoplist;
        this.ct=ct;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =inflater.inflate(R.layout.shopitemlayout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemname.setText(shoplist.get(position).getName());
        holder.itemprice.setText(shoplist.get(position).getPrice());
        holder.itembrand.setText(shoplist.get(position).getBrand());
        Picasso.with(ct).load(shoplist.get(position).getImage()).into(holder.itemimage);

        String name=shoplist.get(position).getName();
        String price=shoplist.get(position).getPrice();
        String old=shoplist.get(position).getOldprice();
        String dis=shoplist.get(position).getDiscount();
        String car1=shoplist.get(position).getCar1();
        String car2=shoplist.get(position).getCar2();
        String car3=shoplist.get(position).getCar3();
        String phone=shoplist.get(position).getPhone();
        String productdes=shoplist.get(position).getLargedata();
        String brand=shoplist.get(position).getBrand();



        holder.itemimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(ct, Shopitempage.class);
                i.putExtra("name", name);
                i.putExtra("price", price);
                i.putExtra("old", old);
                i.putExtra("dis", dis);
                i.putExtra("car1", car1);
                i.putExtra("car2", car2);
                i.putExtra("car3", car3);
                i.putExtra("phone", phone);
                i.putExtra("productdes", productdes);
                i.putExtra("brand",brand);
                ct.startActivity(i);



            }
        });

    }

    @Override
    public int getItemCount() {
        return shoplist.size();
    }

    public void updateList(List<ShopList> temp) {

        shoplist=temp;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView itemname, itembrand, itemprice;
        ImageView itemimage;
      //  Button explore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemname=itemView.findViewById(R.id.shopitemname);
            itembrand=itemView.findViewById(R.id.shopitembrand);
            itemprice=itemView.findViewById(R.id.shopitemprice);
            itemimage=itemView.findViewById(R.id.shopitemimage);





        }
    }

}

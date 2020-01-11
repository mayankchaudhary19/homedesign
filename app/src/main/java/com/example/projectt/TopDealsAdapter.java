package com.example.projectt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopDealsAdapter extends RecyclerView.Adapter<TopDealsAdapter.viewHolder> {
    Context context;
    ArrayList<Products> arrayList;

    public TopDealsAdapter(Context context, ArrayList<Products> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public  TopDealsAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_layout, viewGroup, false);
        return new TopDealsAdapter.viewHolder(view);
    }

    @Override
    public  void onBindViewHolder(com.example.projectt.TopDealsAdapter.viewHolder viewHolder, int position) {
        viewHolder.img5.setImageResource(arrayList.get(position).getImg());
        viewHolder.title5.setText(arrayList.get(position).getTitle());
        viewHolder.subtitle5.setText(arrayList.get(position).getSubtitle());
        viewHolder.price5.setText(arrayList.get(position).getPrice());
        viewHolder.initialPrice5.setText(arrayList.get(position).getInitialPrice());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title5,subtitle5,price5,initialPrice5;
        ImageView img5;

        public viewHolder(View itemView) {
            super(itemView);
            img5 = (ImageView) itemView.findViewById(R.id.product_img);
            title5 = (TextView) itemView.findViewById(R.id.product_name);
            subtitle5 =(TextView) itemView.findViewById(R.id.product_description);
            price5 =(TextView) itemView.findViewById(R.id.product_price);
            initialPrice5 =(TextView) itemView.findViewById(R.id.product_initialPrice);




        }
    }
}


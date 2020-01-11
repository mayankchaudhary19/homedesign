package com.example.projectt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeaturedProductsAdapter extends RecyclerView.Adapter<FeaturedProductsAdapter.viewHolder> {
    Context context;
    ArrayList<Products> arrayList;

    public FeaturedProductsAdapter(Context context, ArrayList<Products> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public  FeaturedProductsAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_layout, viewGroup, false);
        return new FeaturedProductsAdapter.viewHolder(view);
    }

    @Override
    public  void onBindViewHolder(com.example.projectt.FeaturedProductsAdapter.viewHolder viewHolder, int position) {
        viewHolder.img3.setImageResource(arrayList.get(position).getImg());
        viewHolder.title3.setText(arrayList.get(position).getTitle());
        viewHolder.subtitle3.setText(arrayList.get(position).getSubtitle());
        viewHolder.price3.setText(arrayList.get(position).getPrice());
        viewHolder.initialPrice3.setText(arrayList.get(position).getInitialPrice());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title3,subtitle3,price3,initialPrice3;
        ImageView img3;

        public viewHolder(View itemView) {
            super(itemView);
            img3 = (ImageView) itemView.findViewById(R.id.product_img);
            title3 = (TextView) itemView.findViewById(R.id.product_name);
            subtitle3 =(TextView) itemView.findViewById(R.id.product_description);
            price3 =(TextView) itemView.findViewById(R.id.product_price);
            initialPrice3 =(TextView) itemView.findViewById(R.id.product_initialPrice);




        }
    }
}


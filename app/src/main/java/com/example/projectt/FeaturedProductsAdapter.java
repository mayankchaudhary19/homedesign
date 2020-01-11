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
    ArrayList<Categories> arrayList;

    public FeaturedProductsAdapter(Context context, ArrayList<Categories> arrayList) {
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
        viewHolder.t2.setText(arrayList.get(position).getTitle());
        viewHolder.img2.setImageResource(arrayList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView t2;
        ImageView img2;

        public viewHolder(View itemView) {
            super(itemView);
            img2 = (ImageView) itemView.findViewById(R.id.imageView14);
            t2 = (TextView) itemView.findViewById(R.id.textView10);
        }
    }
}


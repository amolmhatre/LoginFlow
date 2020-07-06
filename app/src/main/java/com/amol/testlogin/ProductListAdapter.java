package com.amol.testlogin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by amolmhatre on 7/6/20
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder>
{
    private static final String TAG = "ProductListAdapter";

    private ArrayList<String> list_productImage = new ArrayList<String>();
    private ArrayList<String> list_productNames = new ArrayList<String>();
    private ArrayList<String> list_productPrice = new ArrayList<String>();
    private Context context;

    public ProductListAdapter(Context context, ArrayList<String> list_productImage, ArrayList<String> list_productNames, ArrayList<String> list_productPrice) {
        this.list_productImage = list_productImage;
        this.list_productNames = list_productNames;
        this.list_productPrice = list_productPrice;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"ProductListAdapter/onBindViewHolder "+position);
        Glide.with(context)
                .asBitmap()
                .load(list_productImage.get(position))
                .into(holder.circleImage_product);//This circleImage_product points to one in Layout file
        holder.tv_ProductName.setText(list_productNames.get(position));
        holder.tv_ProductPrice.setText(list_productPrice.get(position));
        //Setting click event on recyclerview item
        holder.parent_product_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Item number "+position+" is clicked");
                Toast.makeText(context,list_productNames.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_productNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImage_product;
        TextView tv_ProductName;
        TextView tv_ProductPrice;
        ConstraintLayout parent_product_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImage_product = itemView.findViewById(R.id.circleImage_product);
            tv_ProductName = itemView.findViewById(R.id.tv_ProductName);
            tv_ProductPrice = itemView.findViewById(R.id.tv_ProductPrice);
            parent_product_item = itemView.findViewById(R.id.parent_product_item);
        }
    }
}

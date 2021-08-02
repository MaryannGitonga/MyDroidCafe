package com.hfad.mydroidcafe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private ArrayList<Store> myStoreData;
    private Context myContext;

    StoreAdapter(ArrayList<Store> storeData, Context context){
        this.myStoreData = storeData;
        this.myContext = context;
    }

    @NonNull
    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreAdapter.ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.store_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.ViewHolder holder, int position) {
        Store currentStore = myStoreData.get(position);
        holder.bindTo(currentStore);
    }

    @Override
    public int getItemCount() {
        return myStoreData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        /*
         * Create a constructor for the ViewHolder used on onCreateViewHolder() method
         * @param itemView referring the rootView of the recipe_list_item_layout
         */

        //        Step 2.2 Declare private member variables that the viewHolder will hold
        private ImageView myStoreImage;
        private TextView myStoreTitle, myStoreDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myStoreImage = itemView.findViewById(R.id.store_image);
            myStoreTitle = itemView.findViewById(R.id.store_title);
            myStoreDescription = itemView.findViewById(R.id.store_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int storePosition = getAdapterPosition();
                    Store currentStore = myStoreData.get(storePosition);
                    if (storePosition == 0 || storePosition == 3){
                        Intent galleriaIntent = new Intent(myContext, StoreActivity.class);
                        galleriaIntent.putExtra("sTitle", currentStore.getStoreTitle());
                        galleriaIntent.putExtra("sImage", currentStore.getStoreImage());
                        galleriaIntent.putExtra("sDescription", currentStore.getStoreDescription());
                        myContext.startActivity(galleriaIntent);
                    }else if (storePosition == 1 || storePosition == 4){
                        Intent twoRiversIntent = new Intent(myContext, StoreActivity.class);
                        twoRiversIntent.putExtra("sTitle", currentStore.getStoreTitle());
                        twoRiversIntent.putExtra("sImage", currentStore.getStoreImage());
                        twoRiversIntent.putExtra("sDescription", currentStore.getStoreDescription());
                        myContext.startActivity(twoRiversIntent);
                    }else if (storePosition == 2 || storePosition == 5){
                        Intent westGateIntent = new Intent(myContext, StoreActivity.class);
                        westGateIntent.putExtra("sTitle", currentStore.getStoreTitle());
                        westGateIntent.putExtra("sImage", currentStore.getStoreImage());
                        westGateIntent.putExtra("sDescription", currentStore.getStoreDescription());
                        myContext.startActivity(westGateIntent);
                    }
                }
            });
        }

        //        Step 6: Create a method to bind the current view with data (Image, title and description)
        public void bindTo(Store currentStore) {
//            Step 6.1: Populate the view with data
//            For loading the image, use the Glide library to prevent the app from crashing as a result of loading many images of different resolutions
//            Implement the Glide library in your module gradle script
            Glide.with(myContext).load(currentStore.getStoreImage()).into(myStoreImage);
            myStoreTitle.setText(currentStore.getStoreTitle());
            myStoreDescription.setText(currentStore.getStoreDescription());
        }
    }
}

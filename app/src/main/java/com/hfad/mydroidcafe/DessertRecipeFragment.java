package com.hfad.mydroidcafe;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class DessertRecipeFragment extends Fragment {
// Declare private member variables
    private RecyclerView dessertRecyclerView;
    private ArrayList<Recipe> dessertRecipeData;
    private RecipeAdapter dessertAdapter;

    public DessertRecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_dessert_recipe, container, false);

//        Step 3: Initialize the recycler view
        dessertRecyclerView = rootView.findViewById(R.id.recycler_dessert);

//        Step 4: Set layout for the recycler view
        dessertRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        Step 5: Initialize the array list that will contain data
        dessertRecipeData = new ArrayList<>();

//        Step 6: Initialize the recipe adapter
        dessertAdapter = new RecipeAdapter(dessertRecipeData, getContext());

//        Step 7: Set the adapter
        dessertRecyclerView.setAdapter(dessertAdapter);

//        Step 8: Get Data
        initializeData();

//        Implement swiping and moving of card items
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();

                Collections.swap(dessertRecipeData, from, to);
                dessertAdapter.notifyItemMoved(from, to);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                dessertRecipeData.remove(viewHolder.getAdapterPosition());
                dessertAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(dessertRecyclerView);

        return rootView;
    }

    private void initializeData() {
//      Step 8.1: Get the data created in the strings.xml file
        String[] dessertTitles = getResources().getStringArray(R.array.dessert_titles);
        String[] dessertDescriptions = getResources().getStringArray(R.array.dessert_descriptions);
        TypedArray dessertImages = getResources().obtainTypedArray(R.array.dessert_images);

//      Step 8.2: Clear existing data to avoid duplication
        dessertRecipeData.clear();

//      Step 8.3: Create an array list of dessert recipes with titles, descriptions and images
        for (int i=0; i < dessertTitles.length; i++){
            dessertRecipeData.add(new Recipe(dessertImages.getResourceId(i, 0), dessertTitles[i], dessertDescriptions[i]));
        }

//      Step 8.4: Clean up the data in the typed array
        dessertImages.recycle();

//      Step 8.5: Notify the adapter of the change in the data set
        dessertAdapter.notifyDataSetChanged();
    }
}
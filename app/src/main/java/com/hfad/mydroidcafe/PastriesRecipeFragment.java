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
public class PastriesRecipeFragment extends Fragment {

    private RecyclerView pastriesRecyclerView;
    private ArrayList<Recipe> pastriesRecipeData;
    private RecipeAdapter pastriesAdapter;

    public PastriesRecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_pastries_recipe, container, false);

        pastriesRecyclerView = rootView.findViewById(R.id.recycler_pastries);

        pastriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        pastriesRecipeData = new ArrayList<>();

        pastriesAdapter = new RecipeAdapter(pastriesRecipeData, getContext());

        pastriesRecyclerView.setAdapter(pastriesAdapter);

        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();

                Collections.swap(pastriesRecipeData, from, to);
                pastriesAdapter.notifyItemMoved(from, to);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                pastriesRecipeData.remove(viewHolder.getAdapterPosition());
                pastriesAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(pastriesRecyclerView);

        return rootView;
    }

    private void initializeData() {
        String[] pastriesTitles = getResources().getStringArray(R.array.dessert_titles);
        String[] pastriesDescriptions = getResources().getStringArray(R.array.dessert_descriptions);
        TypedArray pastriesImages = getResources().obtainTypedArray(R.array.dessert_images);

        pastriesRecipeData.clear();

        for (int i=0; i < pastriesTitles.length; i++){
            pastriesRecipeData.add(new Recipe(pastriesImages.getResourceId(i, 0), pastriesTitles[i], pastriesDescriptions[i]));
        }

        pastriesImages.recycle();

        pastriesAdapter.notifyDataSetChanged();
    }
}
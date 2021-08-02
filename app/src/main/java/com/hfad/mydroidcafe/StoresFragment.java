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
public class StoresFragment extends Fragment {

    private RecyclerView storeRecyclerView;
    private ArrayList<Store> storeRecipeData;
    private StoreAdapter storeAdapter;

    public StoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stores, container, false);

        storeRecyclerView = rootView.findViewById(R.id.recycler_stores);

        storeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        storeRecipeData = new ArrayList<>();

        storeAdapter = new StoreAdapter(storeRecipeData, getContext());

        storeRecyclerView.setAdapter(storeAdapter);

        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();

                Collections.swap(storeRecipeData, from, to);
                storeAdapter.notifyItemMoved(from, to);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                storeRecipeData.remove(viewHolder.getAdapterPosition());
                storeAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(storeRecyclerView);

        return rootView;
    }

    private void initializeData() {
        String[] storeTitles = getResources().getStringArray(R.array.store_titles);
        String[] storeDescriptions = getResources().getStringArray(R.array.store_descriptions);
        TypedArray storeImages = getResources().obtainTypedArray(R.array.store_images);

        storeRecipeData.clear();

        for (int i=0; i < storeTitles.length; i++){
            storeRecipeData.add(new Store(storeImages.getResourceId(i, 0), storeTitles[i], storeDescriptions[i]));
        }

        storeImages.recycle();

        storeAdapter.notifyDataSetChanged();
    }
}
package com.hfad.mydroidcafe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
* Create a recipe adapter that extends RecyclerView.Adapter and use the RecyclerView.ViewHolder class
*/

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{
//    Step 3.0 Declare the private member variables recipeData and the context
    private ArrayList<Recipe> myRecipeData;
    private Context myContext;

//    Create a constructor to pass in the recipeData and context
    RecipeAdapter(ArrayList<Recipe> recipeData, Context context){
        this.myRecipeData = recipeData;
        this.myContext = context;
    }

    /* Step 1.1: Required
    *Implement the method onCreateViewHolder for creating ViewHolder objects
    *@param parent is the view group of which the view object will be added after it is bound to the adapter position
    *@param viewType is the viewType of the new view
    *@return the newly created viewHolder
     */
    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Step 4.2: Create a new viewHolder
        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item, parent, false));
    }

    /* Step 1.1: Required for binding the view to the data
    *@param holder is the viewHolder which the data should be put
    *@position is the adapter position
    */
    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        // Step 5: Get the current view object using its position and populate it with data
        Recipe currentRecipe = myRecipeData.get(position);
        // Step 5.1: Populate the current view with data
        holder.bindTo(currentRecipe);
    }

    /*
    * Step 1.1: Required for getting the size of the data set
    * @return size of data set
    */
    @Override
    public int getItemCount() {
//        Step 4.1
        return myRecipeData.size();
    }

//    Step 2 Create the ViewHolder class that represents each and every row in the recycler view

    public class ViewHolder extends RecyclerView.ViewHolder{
        /*
        * Create a constructor for the ViewHolder used on onCreateViewHolder() method
        * @param itemView referring the rootView of the recipe_list_item_layout
        */

//        Step 2.2 Declare private member variables that the viewHolder will hold
        private ImageView myRecipeImage;
        private TextView myRecipeTitle, myRecipeDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myRecipeImage = itemView.findViewById(R.id.recipe_image);
            myRecipeTitle = itemView.findViewById(R.id.recipe_title);
            myRecipeDescription = itemView.findViewById(R.id.recipe_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition = getAdapterPosition();
                    Recipe currentDessert = myRecipeData.get(dessertPosition);
                    if (dessertPosition == 0 || dessertPosition == 5){
                        Intent donutIntent = new Intent(myContext, DonutActivity.class);
                        donutIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);
                    }else if (dessertPosition == 1 || dessertPosition == 6){
                        Intent froyoIntent = new Intent(myContext, FroyoActivity.class);
                        froyoIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        froyoIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        froyoIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(froyoIntent);
                    }else if (dessertPosition == 2 || dessertPosition == 7){
                        Intent iceCreamIntent = new Intent(myContext, IceCreamActivity.class);
                        iceCreamIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        iceCreamIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        iceCreamIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(iceCreamIntent);
                    }else if (dessertPosition == 3 || dessertPosition == 8){
                        Intent cakeIntent = new Intent(myContext, CakeActivity.class);
                        cakeIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        cakeIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        cakeIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(cakeIntent);
                    }else if (dessertPosition == 4 || dessertPosition == 9){
                        Intent sundaeIntent = new Intent(myContext, SundaeActivity.class);
                        sundaeIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        sundaeIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        sundaeIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(sundaeIntent);
                    }
                }
            });
        }

//        Step 6: Create a method to bind the current view with data (Image, title and description)
        public void bindTo(Recipe currentRecipe) {
//            Step 6.1: Populate the view with data
//            For loading the image, use the Glide library to prevent the app from crashing as a result of loading many images of different resolutions
//            Implement the Glide library in your module gradle script
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());
        }
    }
}

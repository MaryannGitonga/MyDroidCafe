package com.hfad.mydroidcafe;

public class Recipe {
//    Declare private member variables
    private  final  int recipeImage;
    private String recipeTitle, recipeDescription;

//    Create a constructor fot recipe data model
//    Pass the parameters recipeImage, recipeTitle, recipeDescription

    Recipe(int recipeImage, String recipeTitle, String recipeDescription){
        this.recipeImage = recipeImage;
        this.recipeTitle = recipeTitle;
        this.recipeDescription = recipeDescription;
    }

//    Create the getters

    public int getRecipeImage() {
        return recipeImage;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }
}

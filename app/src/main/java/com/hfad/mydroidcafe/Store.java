package com.hfad.mydroidcafe;

public class Store {

    private  final  int storeImage;
    private String storeTitle, storeDescription;

    Store(int storeImage, String storeTitle, String storeDescription){
        this.storeImage = storeImage;
        this.storeTitle = storeTitle;
        this.storeDescription = storeDescription;
    }

    public int getStoreImage() {
        return storeImage;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public String getStoreDescription() {
        return storeDescription;
    }
}

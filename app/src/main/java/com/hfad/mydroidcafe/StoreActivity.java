package com.hfad.mydroidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        TextView storeTitle = findViewById(R.id.s_title);
        storeTitle.setText(getIntent().getStringExtra("sTitle"));

        TextView storeDescription = findViewById(R.id.s_description);
        storeDescription.setText(getIntent().getStringExtra("sDescription"));

        ImageView storeImage = findViewById(R.id.s_image);
        Glide.with(this).load(getIntent().getIntExtra("sImage", 0)).into(storeImage);
    }
}
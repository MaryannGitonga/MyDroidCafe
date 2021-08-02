package com.hfad.mydroidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IceCreamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream);

        TextView iceCreamTitle = findViewById(R.id.ice_cream_title);
        iceCreamTitle.setText(getIntent().getStringExtra("dTitle"));

        TextView iceCreamDescription = findViewById(R.id.ice_cream_description);
        iceCreamDescription.setText(getIntent().getStringExtra("dDescription"));

        ImageView iceCreamImage = findViewById(R.id.ice_cream_image);
        Glide.with(this).load(getIntent().getIntExtra("dImage", 0)).into(iceCreamImage);
    }
}
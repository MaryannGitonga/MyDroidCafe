package com.hfad.mydroidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        TextView cakeTitle = findViewById(R.id.cake_title);
        cakeTitle.setText(getIntent().getStringExtra("dTitle"));

        TextView cakeDescription = findViewById(R.id.cake_description);
        cakeDescription.setText(getIntent().getStringExtra("dDescription"));

        ImageView cakeImage = findViewById(R.id.cake_image);
        Glide.with(this).load(getIntent().getIntExtra("dImage", 0)).into(cakeImage);
    }
}
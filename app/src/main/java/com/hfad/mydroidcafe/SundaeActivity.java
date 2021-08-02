package com.hfad.mydroidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SundaeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundae);

        TextView sundaeTitle = findViewById(R.id.sundae_title);
        sundaeTitle.setText(getIntent().getStringExtra("dTitle"));

        TextView sundaeDescription = findViewById(R.id.sundae_description);
        sundaeDescription.setText(getIntent().getStringExtra("dDescription"));

        ImageView sundaeImage = findViewById(R.id.sundae_image);
        Glide.with(this).load(getIntent().getIntExtra("dImage", 0)).into(sundaeImage);
    }
}
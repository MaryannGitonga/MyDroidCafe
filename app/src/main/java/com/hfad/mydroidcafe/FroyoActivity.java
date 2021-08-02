package com.hfad.mydroidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FroyoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_froyo);

        TextView froyoTitle = findViewById(R.id.froyo_title);
        froyoTitle.setText(getIntent().getStringExtra("dTitle"));

        TextView froyoDescription = findViewById(R.id.froyo_description);
        froyoDescription.setText(getIntent().getStringExtra("dDescription"));

        ImageView froyoImage = findViewById(R.id.froyo_image);
        Glide.with(this).load(getIntent().getIntExtra("dImage", 0)).into(froyoImage);
    }
}
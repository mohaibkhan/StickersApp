package com.example.stickersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ActivityDisplayImage extends AppCompatActivity {

    ImageView image;
    String imagePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        image = findViewById(R.id.image);

        imagePath = getIntent().getStringExtra("image");
        Log.d("imagePath", "onCreate: " + imagePath);
//        imageList = (List<ProductImage>) getIntent().getSerializableExtra("imageList");
        Bitmap bmp = null;
        try {
            URL url = new URL(imagePath);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setImageBitmap(bmp);
    }
}
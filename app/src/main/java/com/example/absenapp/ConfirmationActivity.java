package com.example.absenapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView textViewConfirmName = findViewById(R.id.textViewConfirmName);
        TextView textViewConfirmTime = findViewById(R.id.textViewConfirmTime);
        TextView textViewConfirmLocation = findViewById(R.id.textViewConfirmLocation);
        ImageView imageViewConfirmPhoto = findViewById(R.id.imageViewConfirmPhoto);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String time = intent.getStringExtra("time");
        String location = intent.getStringExtra("location");
        String photoString = intent.getStringExtra("photo");

        textViewConfirmName.setText("Nama: " + name);
        textViewConfirmTime.setText("Waktu: " + time);
        textViewConfirmLocation.setText("Lokasi: " + location);

        // Mengonversi string base64 kembali menjadi Bitmap
        if (photoString != null) {
            Bitmap photo = decodeImage(photoString);
            imageViewConfirmPhoto.setImageBitmap(photo);
        }
    }

    // Mengonversi string base64 menjadi Bitmap
    private Bitmap decodeImage(String imageString) {
        byte[] decodedString = Base64.decode(imageString, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}

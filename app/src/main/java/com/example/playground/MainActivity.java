package com.example.playground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addRoute_Click(View view)
    {

        EditText grading = (EditText)findViewById(R.id.Grading);
        EditText location = (EditText)findViewById(R.id.Location);
        EditText color = (EditText)findViewById(R.id.GripColor);
        CheckBox isBoulder = (CheckBox)findViewById(R.id.isBoulder);


        Route newRoute = new Route("username", grading.getText().toString(),location.getText().toString(),color.getText().toString(), isBoulder.isChecked());

        int resultCode = 1;
        Intent resultIntent = new Intent();
        resultIntent.putExtra("newRoute", newRoute);
        setResult(resultCode, resultIntent);
        finish();
    }

    public void addPicture_Click(View view)
    {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 1);


    }


    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                Uri imageUri = data.getData();
                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                ImageView imageView = findViewById(R.id.imgView);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}

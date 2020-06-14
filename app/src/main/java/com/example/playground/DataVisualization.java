package com.example.playground;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DataVisualization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_visualization);
        //CompletionFragment fragment = new CompletionFragment();
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragments_layout, fragment).commit();
    }

    public void WeatherAPI_Click(View view)
    {
        apiFragment fragment = new apiFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments_layout, fragment).commit();
    }

    public void LocalData_Click(View view)
    {
        LocalData fragment = new LocalData();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments_layout, fragment).commit();
    }
}

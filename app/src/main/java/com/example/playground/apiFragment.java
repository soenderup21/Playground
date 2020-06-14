package com.example.playground;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link apiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class apiFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView temperature;
    private APIViewModel ViewModel;

    private String mParam1;
    private String mParam2;

    public apiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompletionFragment.
     */
    public static apiFragment newInstance(String param1, String param2) {
        apiFragment fragment = new apiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_api, container, false);
        temperature = view.findViewById(R.id.temp_TextView);
        ViewModel = new ViewModelProvider(this ).get(APIViewModel.class);
        ViewModel.init();
        ViewModel.getWeather().observe(getViewLifecycleOwner(), new Observer<WeatherResponse>() {
            @Override
            public void onChanged(WeatherResponse weatherResponse) {
                temperature.setText("Temperature: " + String.valueOf(ViewModel.getWeather().getValue().main.temp-272.15));
            }
        });
        return view;
    }
}

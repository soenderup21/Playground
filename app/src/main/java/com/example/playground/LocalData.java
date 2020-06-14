package com.example.playground;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.example.playground.RoomDB.*;
import com.example.playground.RoomDB.stringRepo;
import com.example.playground.RoomDB.stringsViewModel;
import com.example.playground.RoomDB.stringsDatabase;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocalData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocalData extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LocalData() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocalData.
     */
    public static LocalData newInstance(String param1, String param2) {
        LocalData fragment = new LocalData();
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
        viewmodel = new ViewModelProvider(this).get(stringsViewModel.class);
        viewmodel.getAllStrings().observe(this, new Observer<List<savedString>>() {
            @Override
            public void onChanged(List<savedString> savedStrings) {
                tv.setText(viewmodel.getAllStrings().getValue().get(0).data);
            }
        });
    }
    private TextView tv;
    private stringsViewModel viewmodel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_local_data, container, false);
        Button button = (Button) view.findViewById(R.id.ApplyLocalData);
        final EditText input = view.findViewById(R.id.editLocalData);
        tv = view.findViewById(R.id.savedText);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                savedString string = new savedString(0, input.getText().toString());
                viewmodel.update(string);
            }
        });
        return view;
    }
}

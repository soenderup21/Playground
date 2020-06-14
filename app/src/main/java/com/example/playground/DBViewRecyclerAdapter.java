package com.example.playground;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.playground.data.Result;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DBViewRecyclerAdapter extends RecyclerView.Adapter<DBViewRecyclerAdapter.MyViewHolder> {
    private ArrayList<Route> Dataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView sTextView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textView8);
            sTextView = v.findViewById(R.id.textView9);
        }
    }

    public DBViewRecyclerAdapter(ArrayList<Route> routes) {
        Dataset = routes;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.route_item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Route route = Dataset.get(position);
        holder.mTextView.setText((
                route.Location + ", " +
                route.color));

        holder.sTextView.setText((
                route.grading + ", " +
                route.routeSetterName));
    }

    @Override
    public int getItemCount() {
        return Dataset.size();
    }

}
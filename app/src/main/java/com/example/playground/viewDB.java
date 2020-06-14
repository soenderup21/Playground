package com.example.playground;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class viewDB extends AppCompatActivity {

    private ArrayList<Route> ropeRoutes, boulderRoutes, routes;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: get LoggedInUser object from parent
        setContentView(R.layout.activity_view_db);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        routes = new ArrayList<Route>();
        db.collection("routes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                routes.add(document.get("route", Route.class));
                            }

                            boulderRoutes = new ArrayList<Route>();
                            ropeRoutes = new ArrayList<Route>();
                            for (int i = 0; i < routes.size(); i++){
                                if (routes.get(i).isBoulder){
                                    boulderRoutes.add(routes.get(i));
                                }
                                else{
                                    ropeRoutes.add(routes.get(i));
                                }

                            }
                            routes.clear();
                            routes.addAll(ropeRoutes);

                            Adapter = new DBViewRecyclerAdapter(routes);
                            recyclerView.setAdapter(Adapter);
                        }
                    }
                });
    }

    public final static int REQ_CODE_CHILD = 1;
    public void loadCreateRoute_Click(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, REQ_CODE_CHILD);
    }


    public void loadFragment_Click(View view)
    {
        Intent intent = new Intent(this, DataVisualization.class);
        startActivity(intent);
    }

    public void RemoveRoute_Click(View view)
    {
    }
    private boolean isboulders = false;
    public void TypeSwitch_Click(View view)
    {
        RefreshRecyclerView();
        isboulders = !isboulders;
    }

    private void RefreshRecyclerView(){
        routes.clear();
        if (isboulders) {
            routes.addAll(ropeRoutes);
        }
        else{
            routes.addAll(boulderRoutes);
        }
        Adapter.notifyDataSetChanged();
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            Route route = (Route) data.getExtras().getSerializable("newRoute");
            if (route.isBoulder){
                isboulders = true;
                boulderRoutes.add(route);
            }
            else{
                isboulders = false;
                ropeRoutes.add(route);
            }
            RefreshRecyclerView();
            Map<String, Route> routes = new HashMap<>();
            routes.put("route", route);
            db.collection("routes")
                    .add(routes)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("route", "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("route", "Error adding document", e);
                        }
                    });
        }
    }
}

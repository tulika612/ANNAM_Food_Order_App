package com.example.tulika.myapplication.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tulika.myapplication.Items;
import com.example.tulika.myapplication.ProductAdapter;
import com.example.tulika.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Dessert extends AppCompatActivity implements View.OnClickListener
{

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Items> productList;
    ProductAdapter adapter;
    FloatingActionButton back2,cart;
    Items t;
    FirebaseDatabase database;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        productList=new ArrayList<Items>();
        recyclerView=(RecyclerView) findViewById(R.id.deslist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database=FirebaseDatabase.getInstance();
        db=database.getReference("Items");

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //productList.clear();
                for (DataSnapshot ds: dataSnapshot.child("desserts").getChildren())
                {
                    t=ds.getValue(Items.class);

                    productList.add(t);
                }
                adapter=new ProductAdapter(getApplicationContext(),productList);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        back2=(FloatingActionButton) findViewById(R.id.back2);
        back2.setOnClickListener(this);

        cart=(FloatingActionButton) findViewById(R.id.cart);
        cart.setOnClickListener(this);
        /*productList.add(new product("Brownie",90,R.drawable.imagesb));
        productList.add(new product("Fudge",95,R.drawable.fudge));
        productList.add(new product("Pie",70,R.drawable.imagesb));
        productList.add(new product("Oreo",80,R.drawable.oreo));
        productList.add(new product("Rum Cake",90,R.drawable.rum));
        productList.add(new product("Custard Cake",75,R.drawable.cus));

        adapter=new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);
        back2=(FloatingActionButton) findViewById(R.id.back2);
        back2.setOnClickListener(this);
        cart=(FloatingActionButton) findViewById(R.id.cart);
        cart.setOnClickListener(this);*/
    }

    @Override
    public void onClick(View v) {
        if(v==back2)
        {
            startActivity(new Intent(this,ProfileActivity.class));
        }
        if(v==cart)
        {
            startActivity(new Intent(this,Cart.class));
        }

    }
}
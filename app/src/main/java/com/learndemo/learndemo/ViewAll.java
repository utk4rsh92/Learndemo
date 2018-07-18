package com.learndemo.learndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {
Button btView;
RecyclerView recyclerView;
    List<DataModel> datamodel;
    DatabaseHelper database;
    RecycleAdapter recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        btView = (Button)findViewById(R.id.view);
        datamodel =new ArrayList<DataModel>();
        recyclerView = (RecyclerView)findViewById(R.id.recycle);
        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = new DatabaseHelper(ViewAll.this);
                datamodel = database.getdata();
                recycler = new RecycleAdapter(datamodel);
                RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(reLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recycler);
            }
        });
    }
}

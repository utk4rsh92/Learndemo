package com.learndemo.learndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracActivity extends AppCompatActivity {
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prac);
        TextView tvn = (TextView)findViewById(R.id.tvnb);
        TextView tv = new TextView (this);
        tv.setText("hi im chucky wanna play..?");
        String tvc = tv.getText().toString();
        tvn.setText(tvc);


        btn = (Button)findViewById(R.id.btn_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display();
            }
        });
    }

    private void display() {
        Toast.makeText(getApplicationContext(),"Hi how are you?", Toast.LENGTH_SHORT).show();
    }
}

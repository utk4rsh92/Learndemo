package com.learndemo.learndemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    EditText edEmp;
    EditText edEmpCode;
    EditText edEmpSal;
    EditText edempAge;
    Button bt_save;
    DatabaseHelper databaseHelper;
    String Emp, EmpCode, EmpSal, EmpAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edEmp = (EditText)findViewById(R.id.ed_emp);
        edEmpCode = (EditText)findViewById(R.id.ed_empcode);
        edEmpSal = (EditText)findViewById(R.id.ed_salary);
        edempAge = (EditText)findViewById(R.id.ed_age);


        //databaseHelper = new DatabaseHelper(MainActivity.this);


        bt_save= (Button)findViewById(R.id.btn_save);
        if (getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);

                if (key.equals("AnotherActivity") && value.equals("True")) {
                    Intent intent = new Intent(this, AnotherActivity.class);
                    intent.putExtra("value", value);
                    startActivity(intent);
                    finish();
                }

            }
        }



    
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emp = edEmp.getText().toString();
                EmpCode = edEmpCode.getText().toString();
                EmpSal = edEmpSal.getText().toString();
                EmpAge = edempAge.getText().toString();

                if(Emp.equals("") && EmpCode.equals("") && EmpSal.equals("")&& EmpAge.equals("")){
                    Toast.makeText(MainActivity.this,"Cannot be Blank", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseHelper.insertdata(Emp,EmpCode,EmpSal ,EmpAge);
                    edEmp.setText("");
                    edEmpCode.setText("");
                    edEmpSal.setText("");
                    edempAge.setText("");
                    Toast.makeText(MainActivity.this,"Save Successfully..!", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                          startActivity(new Intent(MainActivity.this, ViewAll.class));
                        }
                    }, 2000);

                }

            }
        });
     //   subscribeToPushService();

    }

    private void subscribeToPushService() {
        FirebaseMessaging.getInstance().subscribeToTopic("news");

        Log.d("AndroidBash", "Subscribed");
        Toast.makeText(MainActivity.this, "Subscribed", Toast.LENGTH_SHORT).show();

        String token = FirebaseInstanceId.getInstance().getToken();

        // Log and toast
        Log.d("AndroidBash", token);
        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
    }

}

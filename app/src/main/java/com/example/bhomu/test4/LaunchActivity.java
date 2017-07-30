package com.example.bhomu.test4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);


        ImageButton blogin=(ImageButton)findViewById(R.id.blogin);
        ImageButton bsignup=(ImageButton)findViewById(R.id.bsignup);
         blogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intentlogin=new Intent(LaunchActivity.this,LoginActivity.class);
                 LaunchActivity.this.startActivity(intentlogin);
             }
         });
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsignup=new Intent(LaunchActivity.this,RegisterActivity.class);
                LaunchActivity.this.startActivity(intentsignup);
            }
        });

    }
}

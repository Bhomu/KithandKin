package com.example.bhomu.test4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PrivacyPolicyActivity extends AppCompatActivity {
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        session = new SessionManager(getApplicationContext());
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Log Out")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        session.logoutUser();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent ii=new Intent(PrivacyPolicyActivity.this,ProfileActivity.class);
                        ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        PrivacyPolicyActivity.this.startActivity(ii);
                    }
                })
                .show();

    }
}

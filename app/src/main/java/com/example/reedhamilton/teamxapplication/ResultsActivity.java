package com.example.reedhamilton.teamxapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Reed Hamilton on 3/21/2017.
 */

public class ResultsActivity extends Activity {
    Button details;
    Button prefs;
    Button logout;
    Button calculate;
    float loc_v;
    float emp_v;
    float sch_v;
    float cst_v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        deets();
        pref();
        calculate();
        logout();
    }

    public void calculate(){
        calculate = (Button) findViewById(R.id.bResultCalc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bun = getIntent().getExtras();
                loc_v = bun.getFloat("location");
                emp_v = bun.getFloat("employment");
                sch_v = bun.getFloat("school");
                cst_v = bun.getFloat("cost");
            }
        });
    }

    public void logout(){
        logout = (Button) findViewById(R.id.bLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kapeesh = new Intent(ResultsActivity.this,LoginActivity.class);
                startActivity(kapeesh);
            }
        });
    }
    public void pref(){
        prefs = (Button) findViewById(R.id.bPreferences);
        prefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dirt = new Intent(ResultsActivity.this, PreferencesActivity.class);
                startActivity(dirt);
            }
        });
    }
    public void deets(){
        details = (Button) findViewById(R.id.bDeets);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String user_name = bundle.getString("username");
                String pwd = bundle.getString("password");
                Intent raw = new Intent(ResultsActivity.this, DetailsActivity.class);
                Bundle bun = new Bundle();
                bun.putString("username",user_name);
                bun.putString("password",pwd);
                raw.putExtras(bun);
                startActivity(raw);
            }
        });
    }
}

package com.example.reedhamilton.teamxapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Reed Hamilton on 3/21/2017.
 */

public class ResultsActivity extends Activity {
    Button details;
    Button prefs;
    Button logout;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        deets();
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

package com.example.reedhamilton.teamxapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register();
    }
    public void register(){
        Button regNew = (Button) findViewById(R.id.bRegisterNew);
        regNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(toy);
            }
        });
    }

}

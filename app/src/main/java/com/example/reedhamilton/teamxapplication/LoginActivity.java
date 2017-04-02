package com.example.reedhamilton.teamxapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    TeamXDBHelper DB;
    Button login;
    EditText user_name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DB = new TeamXDBHelper(this);
        login = (Button) findViewById(R.id.bLogin);
        user_name = (EditText) findViewById(R.id.etUSR);
        password = (EditText) findViewById(R.id.etPWD);
        Login();
        register();
    }

    public void Login(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user_name.getText().toString();
                String pwd = password.getText().toString();
                boolean yes = DB.getPerson(user);
                if (yes == true){
                    boolean yesyes = DB.getPassword(pwd);
                    if (yesyes == true){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        Intent boom = new Intent(LoginActivity.this,ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        String gold = user_name.getText().toString();
                        String key = password.getText().toString();
                        bundle.putString("username",gold);
                        bundle.putString("password",key);
                        boom.putExtras(bundle);
                        startActivity(boom);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Incorrect Password ", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this, "Incorrect Username", Toast.LENGTH_LONG).show();
                }
            }
        });
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

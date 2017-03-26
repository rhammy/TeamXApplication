package com.example.reedhamilton.teamxapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Reed Hamilton on 3/21/2017.
 */

public class RegistrationActivity extends Activity{

    TeamXDBHelper usersDB;
    Button regUser;
    EditText userName, pwd, eMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        usersDB = new TeamXDBHelper(this);
        userName = (EditText) findViewById(R.id.etUsername);
        pwd = (EditText) findViewById(R.id.etPassword);
        eMail = (EditText) findViewById(R.id.eteMail);

        addData();

    }

    public void addData(){
        regUser = (Button) findViewById(R.id.bReg);
        regUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                String password = pwd.getText().toString();
                String email = eMail.getText().toString();
                String blank = null;

                boolean register = usersDB.insertPerson(user,password,blank,blank,0,blank,blank,email);

                if (register == true){
                    Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(RegistrationActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

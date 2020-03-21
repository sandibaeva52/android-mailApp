package com.example.mailapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText username=(EditText)findViewById(R.id.email);
        final EditText password=(EditText)findViewById(R.id.password);
        final EditText nickname=(EditText)findViewById(R.id.nickname);
        Button buttonReg=(Button) findViewById(R.id.signup);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser=username.getText().toString();
                String newPassword=password.getText().toString();
                String newNickname=nickname.getText().toString();
                   SharedPreferences.Editor editor=preferences.edit();
              editor.putString(newUser + newPassword + "data", newUser+"/n"+ newNickname);
             editor.commit();
                Intent LoginScreen=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(LoginScreen);
            }
        });


    }
}

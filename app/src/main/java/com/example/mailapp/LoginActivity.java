package com.example.mailapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;
public class LoginActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button=(Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
        final EditText etEmail=(EditText) findViewById(R.id.email);
        final EditText etPassword=(EditText) findViewById(R.id.password);
Button btnLogin=(Button) findViewById(R.id.login);
        Button btnRegister=(Button) findViewById(R.id.signup);
btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String user =etEmail.getText().toString();
        String password =etPassword.getText().toString();
        SharedPreferences preferences=getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String userDetails=preferences.getString(user +password+"data", "Username or password is incorrect");
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("display",userDetails);
        editor.commit();
        Intent displayScreen=new Intent(LoginActivity.this, MainActivity.class);
        startActivity(displayScreen);
    }
});
btnRegister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent registrationScreen=new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(registrationScreen);
    }
});
    }

    public void openMainActivity() {
   Intent intent= new Intent(this,MainActivity.class);
   startActivity(intent);

    }
}

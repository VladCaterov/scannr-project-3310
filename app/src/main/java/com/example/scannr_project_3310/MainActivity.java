package com.example.scannr_project_3310;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView register,forgotPassword;
    private EditText editEmail, editPassword;
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);
        signIn=(Button) findViewById(R.id.loginButton);
        signIn.setOnClickListener(this);
        editEmail=(EditText) findViewById(R.id.email);
        editPassword=(EditText) findViewById(R.id.password);
        forgotPassword=(TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.register:
//                startActivity(new Intent(this,RegisterUser.class));
                break;
            case R.id.loginButton:
                userLogin();
                break;
            case R.id.forgotPassword:
//                startActivity(new Intent(this,ForgotPassword.class));
                break;
        }
    }
    private void userLogin() {
        String email=editEmail.getText().toString().trim();
        String password=editPassword.getText().toString().trim();
        //path validation
        if(email.isEmpty()){
            editEmail.setError("Email is required!");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Please enter a valid email!");
            editEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editPassword.setError("Password required");
            editPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editPassword.setError("Min password length is 6 char");
            editPassword.requestFocus();
            return;
        }
    }
}
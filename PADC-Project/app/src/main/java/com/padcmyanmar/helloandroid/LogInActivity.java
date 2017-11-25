package com.padcmyanmar.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * Created by Lenovo on 11/5/2017.
 */

public class LogInActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,LogInActivity.class);
        return intent;
    }


    private static final String CORRECT_EMAIL="abc@gmail.com";  //Constant attribute
    private static final String CORRECT_PASSWORD ="abcdef";

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgetPassword;
    private TextView btnNewSellerOrRegister;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btn_login);
        etEmailOrPhone=findViewById(R.id.et_email_or_phone);
        etPassword=findViewById(R.id.et_password);
        btnForgetPassword=findViewById(R.id.btn_forgot_password);
        btnNewSellerOrRegister=findViewById(R.id.btn_new_seller_register);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String emailOrPhone=etEmailOrPhone.getText().toString();
              String password=etPassword.getText().toString();

              if(TextUtils.isEmpty(emailOrPhone)){
                  etEmailOrPhone.setError("Email or Phone cannot be empty");
                  return;
              }

                if(TextUtils.isEmpty(password)){
                  etPassword.setError("Password cannot be Empty");
                  return;
                }

                if(TextUtils.equals(emailOrPhone, CORRECT_EMAIL)
                        && TextUtils.equals(password, CORRECT_PASSWORD)){
                    //Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                   Intent intent=HelloAndroid.newIntent(getApplicationContext());
                    startActivity(intent);
                }
                else
                {
                    Snackbar.make(v,"Incorrect Fmail or Password, Please Try Again",Snackbar.LENGTH_INDEFINITE).show();
                }

              /*  Snackbar.make(v, "Clicked Login", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null).show();
                        */

            }
        });

        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"\"Forget Password\" is Coming soon",Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        btnNewSellerOrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v,"Registration Screen is coming soon",Snackbar.LENGTH_INDEFINITE).show();

                Intent intent= RegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });



    }

}

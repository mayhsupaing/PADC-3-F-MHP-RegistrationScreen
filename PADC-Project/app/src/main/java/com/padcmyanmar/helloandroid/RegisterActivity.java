package com.padcmyanmar.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Lenovo on 11/13/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,RegisterActivity.class);
        return intent;
    }

    private Button btnRegister;
    private TextView btnToLogin;
    private EditText etName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etAddress;
    private RadioGroup rdoGroupGender;
    private RadioButton rdoMale;
    private RadioButton rdoFemale;


   

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister=findViewById(R.id.btn_register);
        btnToLogin=findViewById(R.id.btn_to_login);
        etName=findViewById(R.id.et_name);
        etEmail=findViewById(R.id.et_email);
        etPhone=findViewById(R.id.et_phone);
        etPassword=findViewById(R.id.et_password);
        etConfirmPassword=findViewById(R.id.et_confirm_password);
        etAddress=findViewById(R.id.et_address);
        rdoGroupGender=findViewById(R.id.rdoGroup_gender);
        rdoMale=findViewById(R.id.rdo_male);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String email=etEmail.getText().toString();
                String phone=etPhone.getText().toString();
                String password=etPassword.getText().toString();
                String confirmpassword=etConfirmPassword.getText().toString();
                String address=etAddress.getText().toString();

                if(TextUtils.isEmpty(name)){
                    etName.setError("Name cannot be Empty");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email cannot be Empty");
                    return;
                }

                if(TextUtils.isEmpty(phone)){
                    etPhone.setError("Phone cannot be Empty");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password cannot be Empty");
                    return;
                }

                if (TextUtils.isEmpty(confirmpassword)) {
                    etConfirmPassword.setError("Confirm Password cannot be Empty");
                    return;
                }

                if (TextUtils.isEmpty(address)) {
                    etAddress.setError("Address cannot be Empty");
                    return;
                }


                if(rdoGroupGender.getCheckedRadioButtonId()<=0){//Grp is your radio group object
                    //rdoMale.setError("Gender Cannot be Empty");//Set error to last Radio button
                    Snackbar.make(v,"Gender Cannot be Empty",Snackbar.LENGTH_INDEFINITE).show();
                    return;
                }


                if(TextUtils.equals(password,confirmpassword)){
                    Intent intent= LogInActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }
                else
                {
                    Snackbar.make(v,"Password and Confirm Password doesn't match, Please Try Again",Snackbar.LENGTH_INDEFINITE).show();
                }

                Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_SHORT).show();

            }
        });




       btnToLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent= LogInActivity.newIntent(getApplicationContext());
               startActivity(intent);
           }
       });


    }
}

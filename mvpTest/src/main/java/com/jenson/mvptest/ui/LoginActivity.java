package com.jenson.mvptest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jenson.mvptest.R;
import com.jenson.mvptest.mvp.contact.LoginContact;
import com.jenson.mvptest.mvp.present.LoginPresent;

/**
 * author: CDJenson
 * date: 2020/4/28 15:02
 * version: 1.0
 * description: One-sentence description
 */
public class LoginActivity extends AppCompatActivity implements LoginContact.IView {

    private LoginPresent loginPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresent= new LoginPresent(this);
    }

    @Override
    public void showLoading() {
        ((ProgressBar)findViewById(R.id.loading)).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        ((ProgressBar)findViewById(R.id.loading)).setVisibility(View.GONE);
    }

    @Override
    public String getUserName() {
        return ((EditText)findViewById(R.id.username)).getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return ((EditText)findViewById(R.id.password)).getText().toString().trim();
    }

    @Override
    public void intentToMain(){
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void login(View view){
        loginPresent.login();
    }
}

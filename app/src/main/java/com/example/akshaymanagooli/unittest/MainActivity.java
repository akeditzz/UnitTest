package com.example.akshaymanagooli.unittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginInterface {

    EditText username, password;
    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginPresenter = new LoginPresenter(this,this,new LoginService(this));
    }

    public void onClick(View v) {
        loginPresenter.onLoginClicked();
       if (TextUtils.isEmpty(password.getText().toString().trim())) {

        } else {
            String name = username.getText().toString().trim();
            String pass = password.getText().toString().trim();
            validate(name, pass);
        }
    }

    private void validate(String name, String pass) {
        if (name.equals(getString(R.string.label_akshay)) && pass.equals(getString(R.string.label_1234))) {
            Toast.makeText(this, R.string.label_correct, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, R.string.label_incorrect, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public String getUserName() {
        return username.getText().toString().trim();
    }

    @Override
    public void showUsernameError() {
        username.requestFocus();
        username.setError(getString(R.string.label_required));
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void showPasswordError() {
        password.requestFocus();
        password.setError(getString(R.string.label_required));
    }

    @Override
    public void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }
}

package com.example.akshaymanagooli.unittest;

import android.content.Context;

public class LoginService {
    private Context context;

    public LoginService(Context context) {
        this.context = context;
    }

    public boolean validate(String name, String pass) {
        if (name.equals(context.getString(R.string.label_akshay)) && pass.equals(context.getString(R.string.label_1234))) {
            return true;
        } else {
            return false;
        }
    }
}

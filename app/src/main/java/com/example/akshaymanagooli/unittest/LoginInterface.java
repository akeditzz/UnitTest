package com.example.akshaymanagooli.unittest;

public interface LoginInterface {
    String getUserName();

    void showUsernameError();

    String getPassword();

    void showPasswordError();
    void showToast(int resId);
}

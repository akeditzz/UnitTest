package com.example.akshaymanagooli.unittest;

import android.content.Context;

public class LoginPresenter {

    private Context context;
    private LoginInterface loginInterface;
    private LoginService loginService;

    public LoginPresenter(Context context, LoginInterface loginInterface, LoginService loginService) {
        this.context = context;
        this.loginInterface = loginInterface;
        this.loginService = loginService;
    }

    public void onLoginClicked() {
        String username = loginInterface.getUserName();
        if (username.isEmpty()) {
            loginInterface.showUsernameError();
            return;
        }
        String password = loginInterface.getPassword();
        if (password.isEmpty()) {
            loginInterface.showPasswordError();
            return;
        }else {
            boolean result = loginService.validate(username, password);
            if (result) {
                loginInterface.showToast(R.string.label_correct);
            } else {
                loginInterface.showToast(R.string.label_incorrect);
            }
        }



    }


}

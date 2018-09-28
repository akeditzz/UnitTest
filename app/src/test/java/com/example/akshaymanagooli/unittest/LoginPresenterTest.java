package com.example.akshaymanagooli.unittest;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    private LoginPresenter loginPresenter;
    @Mock
    private LoginInterface loginInterface;
    @Mock
    private LoginService loginService;
    @Mock
    private Context context;

    @Before
    public void setUp() throws Exception {
        loginPresenter = new LoginPresenter(context ,loginInterface, loginService);
    }

    @Test
    public void UsernameNull() {
        when(loginInterface.getUserName()).thenReturn("");
        loginPresenter.onLoginClicked();
        verify(loginInterface).showUsernameError();
    }

    @Test
    public void UsernameSpace() {
        when(loginInterface.getUserName()).thenReturn("      ");
        loginPresenter.onLoginClicked();
        verify(loginInterface).showUsernameError();
    }

    @Test
    public void PasswordNull() {
        when(loginInterface.getUserName()).thenReturn("Akshay");
        when(loginInterface.getPassword()).thenReturn("");
        loginPresenter.onLoginClicked();
        verify(loginInterface).showPasswordError();
    }

    @Test
    public void PasswordSpace() {
        when(loginInterface.getUserName()).thenReturn("Akshay");
        when(loginInterface.getPassword()).thenReturn("      ");
        loginPresenter.onLoginClicked();
        verify(loginInterface).showPasswordError();
    }

    @Test
    public void CorrectDetails() {
        when(loginInterface.getUserName()).thenReturn("Akshay");
        when(loginInterface.getPassword()).thenReturn("1234");
        when(loginService.validate("Akshay","1234")).thenReturn(true);
        loginPresenter.onLoginClicked();
        verify(loginInterface).showToast(R.string.label_correct);
    }

    @Test
    public void InCorrectDetails() {
        when(loginInterface.getUserName()).thenReturn("sfddsfsd");
        when(loginInterface.getPassword()).thenReturn("sfddsfsd");
        when(loginService.validate("sfddsfsd","sfddsfsd")).thenReturn(false);
        loginPresenter.onLoginClicked();
        verify(loginInterface).showToast(R.string.label_incorrect);
    }
}
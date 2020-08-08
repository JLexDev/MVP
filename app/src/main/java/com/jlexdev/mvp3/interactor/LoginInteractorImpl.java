package com.jlexdev.mvp3.interactor;

import android.os.Handler;

import com.jlexdev.mvp3.interfaces.ILoginInteractor;
import com.jlexdev.mvp3.listeners.IOnLoginFinishedListener;


public class LoginInteractorImpl implements ILoginInteractor {

    //private


    @Override
    public void validateCredentials(final IOnLoginFinishedListener listener, final String username, final String password) {
        // Simulate a Login
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ((username.length() > 0) && (password.length() > 0)) {
                    listener.onSuccess();
                } else {
                    listener.onError();
                }
            }
        }, 3000);
    }
}

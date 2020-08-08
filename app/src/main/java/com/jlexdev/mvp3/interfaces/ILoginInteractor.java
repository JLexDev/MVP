package com.jlexdev.mvp3.interfaces;

import com.jlexdev.mvp3.listeners.IOnLoginFinishedListener;

public interface ILoginInteractor {

    void validateCredentials(IOnLoginFinishedListener listener, String username, String password);
}

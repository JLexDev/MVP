package com.jlexdev.mvp3.presenter;

import com.jlexdev.mvp3.interactor.LoginInteractorImpl;
import com.jlexdev.mvp3.interfaces.ILoginInteractor;
import com.jlexdev.mvp3.interfaces.ILoginPresenter;
import com.jlexdev.mvp3.interfaces.ILoginView;
import com.jlexdev.mvp3.listeners.IOnLoginFinishedListener;

public class LoginPresenterImpl implements ILoginPresenter, IOnLoginFinishedListener {

    private ILoginView view;
    private ILoginInteractor interactor;

    public LoginPresenterImpl(ILoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }


    @Override
    public void attempLogin(String username, String password) {
        if (view != null) {
            view.showProgress();
            interactor.validateCredentials(this, username, password);
        }
    }


    @Override
    public void onSuccess() {
        if (view != null) {
            view.hideProgress();
            view.accessSuccesful();
        }
    }

    @Override
    public void onError() {
        if (view != null) {
            view.hideProgress();
            view.accessDenied();
        }
    }
}

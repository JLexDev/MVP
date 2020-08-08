package com.jlexdev.mvp3.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jlexdev.mvp3.R;
import com.jlexdev.mvp3.interfaces.ILoginPresenter;
import com.jlexdev.mvp3.interfaces.ILoginView;
import com.jlexdev.mvp3.presenter.LoginPresenterImpl;

public class LoginView extends AppCompatActivity implements ILoginView {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private ProgressBar progressBar;

    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progress_bar);

        presenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


    private void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        presenter.attempLogin(username, password);
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void accessSuccesful() {
        Toast.makeText(this, "Login Exitoso", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void accessDenied() {
        Toast.makeText(this, "¡Login Denegado!", Toast.LENGTH_SHORT).show();
    }
}

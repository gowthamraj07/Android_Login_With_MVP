package gowtham.android.com.loginappwithmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gowtham.android.com.loginappwithmvp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginPresenter presenter;
    }
}

package gowtham.android.com.loginappwithmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import gowtham.android.com.loginappwithmvp.presenter.LoginPresenter;
import gowtham.android.com.loginappwithmvp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private TextView tvUserIdError;
    private TextView tvPasswordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvUserIdError = findViewById(R.id.tv_user_id_error_message);
        tvPasswordError = findViewById(R.id.tv_password_error_message);

        LoginPresenter presenter;
    }

    @Override
    public void hideUserIdError() {
        tvUserIdError.setVisibility(View.GONE);
    }

    @Override
    public void hidePasswordError() {
        tvPasswordError.setVisibility(View.GONE);
    }

    @Override
    public void showUserIdError() {
        tvUserIdError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPasswordError() {
        tvPasswordError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNextScreen() {
        Toast.makeText(this, "Logic to show next screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInvalidCredentialsError() {
        Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
    }
}

package gowtham.android.com.loginappwithmvp.presenter;

import gowtham.android.com.loginappwithmvp.view.LoginView;

public class LoginPresenter {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void initialize() {
        view.hideUserIdError();
        view.hidePasswordError();
    }
}

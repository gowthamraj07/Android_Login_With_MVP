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

    public void signIn(String userId, String password) {
        if(password == null) {
            view.showPasswordError();
            return;
        }

        if(userId == null) {
            view.showUserIdError();
            return;
        }

        if(userId.isEmpty()) {
            view.showUserIdError();
        }
    }
}

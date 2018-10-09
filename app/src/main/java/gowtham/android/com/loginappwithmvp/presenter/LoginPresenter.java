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
        view.hideUserIdError();
        view.hidePasswordError();

        boolean isInvalidPassword = isInValid(password);
        if (isInvalidPassword) {
            view.showPasswordError();
        }

        boolean isInvalidUserId = isInValid(userId);
        if (isInvalidUserId) {
            view.showUserIdError();
        }

    }

    private boolean isInValid(String text) {
        return text == null || text.isEmpty();
    }
}

package gowtham.android.com.loginappwithmvp.view;

public interface LoginView {
    void hideUserIdError();
    void hidePasswordError();

    void showUserIdError();
    void showPasswordError();

    void showNextScreen();
    void showInvalidCredentialsError();
}

package gowtham.android.com.loginappwithmvp.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import gowtham.android.com.loginappwithmvp.view.LoginView;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

    private LoginView view;
    private LoginPresenter presenter;

    private static final String NULL_PASSWORD = null;
    private static final String NULL_USER_ID = null;

    private static final String ANY_USER_ID = "any user id";
    private static final String ANY_PASSWORD = "any password";

    private static final String EMPTY_PASSWORD = "";
    private static final String EMPTY_USER_ID = "";

    @Before
    public void setUp() {
        view = Mockito.mock(LoginView.class);
        presenter = new LoginPresenter(view);
    }

    @Test
    public void shouldHideErrorMessagesWhenInitializing() {
        presenter.initialize();

        verify(view).hideUserIdError();
        verify(view).hidePasswordError();
    }

    @Test
    public void showUserIdErrorWhenUserIdIsEmpty() {
        presenter.signIn(EMPTY_USER_ID, ANY_PASSWORD);

        verify(view).showUserIdError();
        verify(view, times(0)).showNextScreen();
    }

    @Test
    public void showUserIdErrorWhenUserIdIsNull() {
        presenter.signIn(NULL_USER_ID, ANY_PASSWORD);

        verify(view).showUserIdError();
        verify(view, times(0)).showNextScreen();
    }

    @Test
    public void showPasswordErrorWhenPasswordIsNull() {
        presenter.signIn(ANY_USER_ID, NULL_PASSWORD);

        verify(view).showPasswordError();
        verify(view, times(0)).showNextScreen();
    }

    @Test
    public void showPasswordErrorWhenPasswordIsEmpty() {
        presenter.signIn(ANY_USER_ID, EMPTY_PASSWORD);

        verify(view).showPasswordError();
        verify(view, times(0)).showNextScreen();
    }

    @Test
    public void showUserIdAndPasswordErrorWhenBothAreInvalid() {
        presenter.signIn(NULL_USER_ID, NULL_PASSWORD);

        InOrder userIdInOrder = inOrder(view);
        userIdInOrder.verify(view).hideUserIdError();
        userIdInOrder.verify(view).showUserIdError();
        InOrder passwordInOrder = inOrder(view);
        passwordInOrder.verify(view).hidePasswordError();
        passwordInOrder.verify(view).showPasswordError();
        verify(view, times(0)).showNextScreen();
    }

    @Test
    public void shouldSignInWhenCredentialsAreValid() {
        presenter.signIn(LoginPresenter.USERID, LoginPresenter.PASSWORD);

        InOrder userIdInOrder = inOrder(view);
        userIdInOrder.verify(view).hideUserIdError();
        userIdInOrder.verify(view, times(0)).showUserIdError();
        InOrder passwordInOrder = inOrder(view);
        passwordInOrder.verify(view).hidePasswordError();
        passwordInOrder.verify(view, times(0)).showPasswordError();
        verify(view).showNextScreen();
    }

    @Test
    public void shouldShowErrorForInvalidCredentials() {
        presenter.signIn("invalid user id", "invalid password");

        InOrder userIdInOrder = inOrder(view);
        userIdInOrder.verify(view).hideUserIdError();
        userIdInOrder.verify(view, times(0)).showUserIdError();
        InOrder passwordInOrder = inOrder(view);
        passwordInOrder.verify(view).hidePasswordError();
        passwordInOrder.verify(view, times(0)).showPasswordError();
        verify(view, times(0)).showNextScreen();
    }
}
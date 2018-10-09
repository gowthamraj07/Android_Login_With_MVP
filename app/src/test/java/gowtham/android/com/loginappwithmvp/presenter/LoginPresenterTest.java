package gowtham.android.com.loginappwithmvp.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import gowtham.android.com.loginappwithmvp.view.LoginView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

    private LoginView view;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
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
        String emptyUserId = "";
        String anyPassword = "any password";
        presenter.signIn(emptyUserId, anyPassword);

        verify(view).showUserIdError();
    }

    @Test
    public void showUserIdErrorWhenUserIdIsNull() {
        String nullUserId = null;
        String anyPassword = "any password";
        presenter.signIn(nullUserId, anyPassword);

        verify(view).showUserIdError();
    }
}
package gowtham.android.com.loginappwithmvp.presenter;

import org.junit.Test;
import org.mockito.Mockito;

import gowtham.android.com.loginappwithmvp.view.LoginView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

    @Test
    public void shouldHideErrorMessagesWhenInitializing() {
        LoginView view = Mockito.mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(view);

        presenter.initialize();

        verify(view).hideUserIdError();
        verify(view).hidePasswordError();
    }
}
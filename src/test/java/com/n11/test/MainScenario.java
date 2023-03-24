package com.n11.test;

import com.n11.driver.BaseTest;
import com.n11.methods.Methods;
import com.n11.page.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author BurhanAydın - github.com/Burhan1925
 */
public class MainScenario extends BaseTest {
    LoginPage loginPage;
    Methods methods;

    @Before
    public void setup() {
        loginPage = new LoginPage();
        methods = new Methods();
    }

    @Test
    public void loginSuccess() {
        loginPage.login();
    }

    @Test
    public void emptyMailAndEmptyPassword() {
        loginPage.loginFailureOne();
    }

    @Test
    public void emptyMailAndPassword() {
        loginPage.loginFailureTwo();
    }

    @Test
    public void mailAndEmptyPassword() {
        loginPage.loginFailureThree();
    }

    @Test
    public void mailAndPasswordInvalid() {
        loginPage.loginFailureFour();
    }

    @Test
    public void passwordCharacterCountInvalid() {
        loginPage.loginFailureFive();
    }
}

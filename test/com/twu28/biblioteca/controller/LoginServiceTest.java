package com.twu28.biblioteca.controller;

import com.twu28.biblioteca.Service.LoginService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService();
    }

    @Test
    public void should_login_success_with_valid_username_and_password(){
        assertThat(loginService.login("1", "password"), is(true));
    }

    @Test
    public void should_login_fail_with_invalid_username_and_password(){
        assertThat(loginService.login("1", "invalid password"), is(false));
        assertThat(loginService.login("invalid id", "password"), is(false));
    }

    @Test
    public void should_be_able_to_log_out() {
        loginService.logout();
        assertThat(loginService.getCurrentUser(), nullValue());
    }

}

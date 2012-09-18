package com.twu28.biblioteca.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void should_judge_if_the_given_user_ID_and_name_equal_user(){
        String melodyID = "melody";
        String password = "123456";
        String wrongPassword = "134334";
        String wrongUserId = "134334";

        User user = new User(melodyID, password);
        assertThat(user.isEqual(new User(melodyID, password)), is(true));
        assertThat(user.isEqual(new User(melodyID, wrongPassword)), is(false));
        assertThat(user.isEqual(new User(wrongUserId, password)), is(false));

    }
}

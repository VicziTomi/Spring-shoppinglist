package hu.flowacademy.shoppinglist.exception;

import hu.flowacademy.shoppinglist.domain.Users;

public class UserInvalidException extends RuntimeException {

    public UserInvalidException(Users user) {
        super("Invalid user: " + user);
    }
}

package hu.flowacademy.shoppinglist.exception;

public class UserMisMatchException extends RuntimeException {

    public UserMisMatchException(String userName) {
        super("Nincs meg " + userName + " bazzz...");
    }
}

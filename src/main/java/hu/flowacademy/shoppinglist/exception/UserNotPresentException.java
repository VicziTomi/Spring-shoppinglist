package hu.flowacademy.shoppinglist.exception;

public class UserNotPresentException extends RuntimeException {

    public UserNotPresentException() {
        super("Nincs júzer, Bazzzz+");
    }
}

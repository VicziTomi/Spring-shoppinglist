package hu.flowacademy.shoppinglist.exception;

public class ShoppingListItemMismatchException extends RuntimeException {


    public ShoppingListItemMismatchException (String id) {
        super("Could not find item " + id);
    }
}

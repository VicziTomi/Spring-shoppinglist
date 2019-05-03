package hu.flowacademy.shoppinglist.exception;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;

public class ShoppingListItemNotFoundException extends RuntimeException {

    public ShoppingListItemNotFoundException(ShoppingListItem id) {
        super("Item not found " + id);
    }


}

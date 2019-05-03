package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.exception.ShoppingListItemMismatchException;
import hu.flowacademy.shoppinglist.exception.ShoppingListItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShoppingListRepository {

    private Map<String, ShoppingListItem> shoppingList = new HashMap<>();

    public ShoppingListItem addItem(ShoppingListItem item) {
        shoppingList.put(item.getId(), item);
        return item;
    }

    public ShoppingListItem modifyItem (ShoppingListItem modItem) {
        if (modItem.getId() != null) {
            shoppingList.remove(modItem.getId());
            shoppingList.put(modItem.getId(), modItem);
        }
        throw new ShoppingListItemNotFoundException(modItem);
    }

    public String deleteItem (String id) {
        if (shoppingList.get(id).equals(id)) {
            shoppingList.remove(id);
            return id;
        }
        throw new ShoppingListItemMismatchException(id);
    }

    public List<ShoppingListItem> getAllItems () {
        return new ArrayList<>(shoppingList.values());
    }

    public ShoppingListItem getSelectedItem (String id) {
        if (shoppingList.get(id).equals(id)) {
            return shoppingList.get(id);
        }
        throw new ShoppingListItemMismatchException(id);
    }
}

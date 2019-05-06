package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.exception.ShoppingListItemMismatchException;
import hu.flowacademy.shoppinglist.exception.ShoppingListItemNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListItem, String> {

    void deleteById(String id);

    // ShoppingListItem getItem(String id);

    // ShoppingListItem save(ShoppingListItem item);

    // ShoppingListItem modifyItem(ShoppingListItem item);

    // List<ShoppingListItem> allItems();

}

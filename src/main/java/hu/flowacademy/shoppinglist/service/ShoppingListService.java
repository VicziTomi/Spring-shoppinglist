package hu.flowacademy.shoppinglist;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.exception.ShoppingListItemMismatchException;
import hu.flowacademy.shoppinglist.exception.ShoppingListItemNotFoundException;
import hu.flowacademy.shoppinglist.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    public ShoppingListRepository shoppingListRepository;

    public ShoppingListItem addItem(ShoppingListItem item) {
        return shoppingListRepository.addItem(item);
    }

    public ShoppingListItem getItem(String id) {
        if (shoppingListRepository.findById(id).isPresent()) {
            return shoppingListRepository.getItem(id);
        }
        throw new ShoppingListItemMismatchException(id);
    }

    public void deleteById(String id) {
        try {
            shoppingListRepository.deleteById(id);
        } catch (Exception e) {
            throw new ShoppingListItemMismatchException(id);
        }
    }

    public List<ShoppingListItem> getAllItems() {
        return shoppingListRepository.getAllItems();
    }

    public ShoppingListItem modifyItem(ShoppingListItem item) {
        return shoppingListRepository.modifyItem(item);
    }

}

package hu.flowacademy.shoppinglist;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
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

    public ShoppingListItem modifyItem(ShoppingListItem item) {
        return shoppingListRepository.modifyItem(item);
    }

    public String deleteItem(String id) {
        return shoppingListRepository.deleteItem(id);
    }

    public List<ShoppingListItem> getAllItems () {
        return shoppingListRepository.getAllItems();
    }

    public ShoppingListItem getSelectedItem (String id) {
        return shoppingListRepository.getSelectedItem(id);
    }
}

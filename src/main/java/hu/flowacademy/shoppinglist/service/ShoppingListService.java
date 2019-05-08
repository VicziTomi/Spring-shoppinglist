package hu.flowacademy.shoppinglist.service;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.exception.ShoppingListItemMismatchException;
import hu.flowacademy.shoppinglist.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    public ShoppingListRepository shoppingListRepository;

    public ShoppingListItem save(ShoppingListItem item) {
        return shoppingListRepository.save(item);
    }

    public ShoppingListItem getOneItem(String id) {
        if (shoppingListRepository.findById(id).isPresent()) {
            return shoppingListRepository.findById(id).get();
        }
        throw new ShoppingListItemMismatchException(id);
    }

    public void delete(String id) {
        try {
            shoppingListRepository.deleteById(id);
        } catch (Exception e) {
            throw new ShoppingListItemMismatchException(id);
        }
    }

    public List<ShoppingListItem> allItems() {
        return shoppingListRepository.findAll();
    }

    public int ShoppingItemsByGivenUser(String name) {
        return shoppingListRepository.ShoppingItemsByGivenUser(name);
    }

    /*
    public ShoppingListItem modifyItem(ShoppingListItem item) {
        return shoppingListRepository.modifyItem(item);
    }

     */


}

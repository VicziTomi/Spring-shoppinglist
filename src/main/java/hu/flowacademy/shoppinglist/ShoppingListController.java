package hu.flowacademy.shoppinglist;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/list")
public class ShoppingListController {

    private Map<String, ShoppingListItem> shoppingList = new HashMap<>();


    @PostMapping("/add")
    public ResponseEntity<ShoppingListItem> addItem (@RequestBody ShoppingListItem item) {
        shoppingList.put(item.getId(), item);
        System.err.println(item.toString());
        return ResponseEntity.ok(item);
    }

    @PostMapping("/addmult")
    public ResponseEntity<List<ShoppingListItem>> addItems (@RequestBody List<ShoppingListItem> items) {
        for (ShoppingListItem s: items) {
            shoppingList.put(s.getId(), s);
            System.err.println(items);

        }
        return ResponseEntity.ok(items);
    }

    @PutMapping("/modify")
    public ResponseEntity<ShoppingListItem> modifyItem (@RequestBody ShoppingListItem item) {
        ShoppingListItem modItem = shoppingList.get(item.getId());
        if (modItem != null) {
            shoppingList.remove(item.getId());
            shoppingList.put(item.getId(), item);
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.ok(modItem);
    }

    @DeleteMapping("/delete/{id}")
    public String seletedItem (@PathVariable String id) {
        if (shoppingList.get(id).getId().equals(id)) {
            shoppingList.remove(id);
            return id;
        }
        return "Delete FAIL";

    }

    @GetMapping("/allitems")
    public ResponseEntity<List<ShoppingListItem>> allitems () {
        List<ShoppingListItem> listItems = new ArrayList<>(shoppingList.values());
        return ResponseEntity.ok(listItems);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ShoppingListItem> getSelected (@PathVariable String id) {
        if (shoppingList.get(id).getId().equals(id)) {
            return ResponseEntity.ok(shoppingList.get(id));
        }
        return new ResponseEntity<ShoppingListItem>(null, null, null); // nem megy!!! új példány kellene, amit utána vissza is ad.
    }

}

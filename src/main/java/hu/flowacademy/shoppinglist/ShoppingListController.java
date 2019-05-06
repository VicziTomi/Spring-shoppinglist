package hu.flowacademy.shoppinglist;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/list")
public class ShoppingListController {

    private Map<String, ShoppingListItem> shoppingList = new HashMap<>();

    @Autowired
    private ShoppingListService shoppingListService;

    @PostMapping("/add")
    public ResponseEntity<ShoppingListItem> addItem (@RequestBody ShoppingListItem item) {
        return ResponseEntity.ok(shoppingListService.addItem(item));
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
        return ResponseEntity.ok(shoppingListService.modifyItem(item));
    }

    @DeleteMapping("/delete/{id}")
    public String seletedItem (@PathVariable String id) {
        shoppingListService.deleteItem(id);
        return "Hepp";

    }

    @GetMapping("/allitems")
    public ResponseEntity<List<ShoppingListItem>> allitems () {
        return ResponseEntity.ok(shoppingListService.getAllItems());
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ShoppingListItem> getSelected (@PathVariable String id) {
        return ResponseEntity.ok(shoppingListService.getSelectedItem(id));
    }

}

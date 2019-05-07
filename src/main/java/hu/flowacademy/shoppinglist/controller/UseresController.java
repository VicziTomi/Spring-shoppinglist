package hu.flowacademy.shoppinglist.controller;

import hu.flowacademy.shoppinglist.domain.Users;
import hu.flowacademy.shoppinglist.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
public class UseresController {

    private Map<String, Users> usersList = new HashMap<>();

    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public ResponseEntity<Users> addUser (@RequestBody Users user) {
        return ResponseEntity.ok(usersService.save(user));
    }

    @PutMapping("/modify/{userName}")
    public ResponseEntity<Users> modifyUser (@RequestBody Users user) {
        return ResponseEntity.ok(usersService.modify(user));
    }

    @DeleteMapping("/delete/{userName}")
    public String deleteUser (@PathVariable String userName) {
        usersService.delete(userName);
        return "Kitöröltem, wazze!";
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<Users> getUser (@PathVariable String userName) {
        return ResponseEntity.ok(usersService.getOneUser(userName));
    }

    @GetMapping("/allusers")
    public  ResponseEntity<List<Users>> getAllUseres () {
        return ResponseEntity.ok(usersService.allUsers());
    }

}

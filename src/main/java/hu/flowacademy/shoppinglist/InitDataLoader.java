package hu.flowacademy.shoppinglist;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.domain.Users;
import hu.flowacademy.shoppinglist.repository.ShoppingListRepository;
import hu.flowacademy.shoppinglist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Override
    public void run(String... args) {

        Users user1 = new Users("karesz", "pwd", "Kiraly Karesz");
        Users user2 = new Users("marcsi", "cuki", "Cuki Marcsi");
        Users user3 = new Users("aladar", "macska", "Luke Aladar");
        Users user4 = new Users("tescoAdmin", "spar", "Tesco Admin");

        usersRepository.save(user1);
        usersRepository.save(user2);
        usersRepository.save(user3);
        usersRepository.save(user4);

        ShoppingListItem s1 = new ShoppingListItem("001", "tej", "milkProducts", 4, 129, "szlovák", user1);
        ShoppingListItem s2 = new ShoppingListItem("002", "sajt", "milkProducts", 12, 2349, "finom", user2);
        ShoppingListItem s3 = new ShoppingListItem("003", "asdf", "asfnhpa", 234, 12, "spfknh", user3);


        shoppingListRepository.save(s1);
        shoppingListRepository.save(s2);
        shoppingListRepository.save(s3);

    }

}
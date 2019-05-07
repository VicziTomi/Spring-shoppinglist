package hu.flowacademy.shoppinglist.service;

import hu.flowacademy.shoppinglist.domain.Users;
import hu.flowacademy.shoppinglist.exception.UserInvalidException;
import hu.flowacademy.shoppinglist.exception.UserMisMatchException;
import hu.flowacademy.shoppinglist.exception.UserNotPresentException;
import hu.flowacademy.shoppinglist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    public UsersRepository usersRepository;

    public Users save(Users user) {
        return usersRepository.save(user);
    }

    public Users modify(Users user) {
        if (usersRepository.findById(user.getUserName()).isPresent()) {
            return usersRepository.save(user);
        }
        throw new UserInvalidException(user);
    }

    public Users getOneUser(String userName) {
        if (usersRepository.findById(userName).isPresent()) {
            return usersRepository.findById(userName).get();
        }
        throw new UserNotPresentException();
    }

    public void delete(String userName) {
        try {
            usersRepository.deleteById(userName);
        } catch (UserMisMatchException e) {
            throw new UserMisMatchException(userName);
        }
    }

    public List<Users> allUsers() {
        return usersRepository.findAll();
    }

}

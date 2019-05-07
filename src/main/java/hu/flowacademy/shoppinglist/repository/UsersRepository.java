package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {


}

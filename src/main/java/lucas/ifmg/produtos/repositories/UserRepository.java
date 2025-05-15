package lucas.ifmg.produtos.repositories;

import lucas.ifmg.produtos.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Query Methods:
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
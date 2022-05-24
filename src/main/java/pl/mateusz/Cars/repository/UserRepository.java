package pl.mateusz.Cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.Cars.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

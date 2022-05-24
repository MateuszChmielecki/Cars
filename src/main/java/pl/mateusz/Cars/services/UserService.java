package pl.mateusz.Cars.services;

import org.springframework.stereotype.Component;
import pl.mateusz.Cars.entity.User;
@Component
public interface UserService {

    User findByUserName(String name);
    void saveUser(User user);
    void saveAdmin(User user);
}

package pl.mateusz.Cars.services;

import org.springframework.stereotype.Component;
import pl.mateusz.Cars.entity.Group;

import java.util.List;
import java.util.Optional;

@Component
public interface GroupService{
    List<Group> findAll();
    Optional<Group> findById(Long id);
    void save(Group group);
    void delete(Long id);
    void update(Group group);
}

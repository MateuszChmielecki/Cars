package pl.mateusz.Cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.Cars.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}

package pl.mateusz.Cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.Cars.entity.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}

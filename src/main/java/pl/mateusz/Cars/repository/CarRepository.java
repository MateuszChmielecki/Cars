package pl.mateusz.Cars.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.Cars.entity.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}

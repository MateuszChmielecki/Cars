package pl.mateusz.Cars.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.Cars.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}

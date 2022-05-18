package pl.mateusz.Cars.services;

import org.springframework.stereotype.Component;
import pl.mateusz.Cars.entity.Car;

import java.util.List;
import java.util.Optional;

@Component
public interface CarService {
    List<Car> findAll();
    Optional<Car> findById(Long id);
    void save(Car car);
    void delete(Long id);
    void update(Car car);

}

package pl.mateusz.Cars.services;

import org.springframework.stereotype.Component;
import pl.mateusz.Cars.entity.Brand;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.entity.Group;

import java.util.List;
import java.util.Optional;

@Component
public interface CarService {
    List<Car> findAll();
    Optional<Car> findById(Long id);
    void save(Car car);
    void delete(Long id);
    void update(Car car);
    List<Car> findAllByModel(String model);
    List<Car> findAllByModelCode(String modelCode);
    List<Car> findAllByBrand(Brand brand);
    List<Car> findAllByBrand_Group(Group group);

}

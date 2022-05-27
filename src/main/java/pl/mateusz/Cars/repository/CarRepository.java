package pl.mateusz.Cars.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.Cars.entity.Brand;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.entity.Group;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByModel(String model);
    List<Car> findAllByModelCode(String modelCode);
    List<Car> findAllByBrand(Brand brand);
    List<Car> findAllByBrand_Group(Group group);
}

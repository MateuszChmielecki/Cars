package pl.mateusz.Cars.services;

import org.springframework.stereotype.Service;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaCarService implements CarService{
    private final CarRepository carRepository;

    public JpaCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {

        return carRepository.findById(id);
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void update(Car car) {
        carRepository.save(car);
    }
}

package pl.mateusz.Cars.services;

import org.springframework.stereotype.Component;
import pl.mateusz.Cars.entity.Brand;

import java.util.List;
import java.util.Optional;

@Component
public interface BrandService {
    List<Brand> findAll();
    Optional<Brand> findById(Long id);
    void save(Brand brand);
    void delete(Long id);
    void update(Brand brand);
}

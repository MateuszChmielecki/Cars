package pl.mateusz.Cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mateusz.Cars.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}

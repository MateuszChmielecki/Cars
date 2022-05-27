package pl.mateusz.Cars.services;

import org.springframework.stereotype.Service;
import pl.mateusz.Cars.entity.Brand;
import pl.mateusz.Cars.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaBrandService implements BrandService{

    private final BrandRepository brandRepository;

    public JpaBrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public void update(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public Brand findByName(String name) {
        return brandRepository.findByName(name);
    }
}

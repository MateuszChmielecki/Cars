package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mateusz.Cars.models.Brand;
import pl.mateusz.Cars.models.Car;
import pl.mateusz.Cars.models.Group;
import pl.mateusz.Cars.models.SegmentType;
import pl.mateusz.Cars.repository.BrandRepository;
import pl.mateusz.Cars.repository.CarRepository;
import pl.mateusz.Cars.repository.GroupRepository;

@Controller
public class DataController {
    private final CarRepository carRepository;
    private final GroupRepository groupRepository;
    private final BrandRepository brandRepository;

    public DataController(CarRepository carRepository, GroupRepository groupRepository, BrandRepository brandRepository) {
        this.carRepository = carRepository;
        this.groupRepository = groupRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/data")
    public String home() {
        Group vw = new Group(1L, "Volkswagen", "Germany");
        groupRepository.save(vw);
        Brand volkswagen = new Brand(1L ,"Audi", vw, "Germany");
        brandRepository.save(volkswagen);
        Car audiA38l = new Car(1L, volkswagen,"A3", "8L", 1996, 2003, SegmentType.C,"zdjecie");
        carRepository.save(audiA38l);
        return "index";
    }

    @GetMapping("/home_reps")
    @ResponseBody
    public String respBody() {
        return "Surowy tekst";
    }
}


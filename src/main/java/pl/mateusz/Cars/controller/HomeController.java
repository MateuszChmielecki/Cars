package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mateusz.Cars.models.SegmentType;
import pl.mateusz.Cars.repository.BrandRepository;
import pl.mateusz.Cars.repository.CarRepository;
import pl.mateusz.Cars.models.Brand;
import pl.mateusz.Cars.models.Car;
import pl.mateusz.Cars.models.Group;
import pl.mateusz.Cars.repository.GroupRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HomeController {

    private final CarRepository carRepository;
    private final GroupRepository groupRepository;
    private final BrandRepository brandRepository;

    public HomeController(CarRepository carRepository, BrandRepository brandRepository, GroupRepository groupRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.groupRepository = groupRepository;
    }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("CarSegment", SegmentType.values());
        return "addCar";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addCarForm(@Valid Car car) {

        carRepository.save(car);

        return "Zapisano";
    }

    @GetMapping("/update")
    public String updateCar() {

        return "update";
    }

    @GetMapping("/list")
        public String listCars(Model model){
        model.addAttribute("cars", carRepository.findAll());
        return "list-car";
        }
}




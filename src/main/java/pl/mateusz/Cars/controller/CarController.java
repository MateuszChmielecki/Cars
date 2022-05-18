package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.enums.SegmentType;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;

@Controller
public class CarController {

    private final CarService carService;
    private final BrandService brandService;
    private final GroupService groupService;

    public CarController(CarService carService, BrandService brandService, GroupService groupService) {
        this.carService = carService;
        this.brandService = brandService;
        this.groupService = groupService;
    }

    @GetMapping("/listCar")
    public String listCars(Model model){
        model.addAttribute("cars", carService.findAll());
        return "listCar";
    }

    @GetMapping("/addCar")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("CarSegment", SegmentType.values());
        model.addAttribute("brand", brandService.findAll());
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addCarForm(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "addCar";
        }
        carService.save(car);
        return "redirect:/listCar" ;
    }

    @GetMapping("/updateCar/{id}")
    public String updateCar(@PathVariable String id, Model model){

        if(carService.findById(Long.parseLong(id)).isPresent()) {

            model.addAttribute("car", carService.findById(Long.parseLong(id)).get());
            model.addAttribute("CarSegment", SegmentType.values());
            model.addAttribute("brand", brandService.findAll());
            return "updateCar";
        }

        return "updateCar";
    }


    @PostMapping("/updateCar/{id}")
    public String updateCarForm(@PathVariable Long id,@Valid Car car){
        carService.update(car);
        return "redirect:/listCar";
    }

    @GetMapping("deleteCar/{id}")
    public String deleteCar(@PathVariable String id, Model model){
        model.addAttribute("id", id);
        carService.delete(Long.parseLong(id));
        return "deleteCar";
    }
}

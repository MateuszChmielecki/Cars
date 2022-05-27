package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

@Controller
@RequestMapping(path="/Cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;

    }

    @GetMapping("/listCar")
    public String listCars(Model model){
        model.addAttribute("cars", carService.findAll());
        return "car/listCar";
    }

    @GetMapping("/search")
    public String SearchCars(){
        return "search";
    }

    @PostMapping("/search")
    public String SearchCarsForm(Model model){

        model.addAttribute("cars", carService.findAll());
        return "car/listCar";
    }

}

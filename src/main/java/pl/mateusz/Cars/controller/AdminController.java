package pl.mateusz.Cars.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.enums.SegmentType;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping(path="/Admin")
public class AdminController {

    private final CarService carService;
    private final BrandService brandService;
    private final GroupService groupService;

    public AdminController(CarService carService, BrandService brandService, GroupService groupService) {
        this.carService = carService;
        this.brandService = brandService;
        this.groupService = groupService;
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
}

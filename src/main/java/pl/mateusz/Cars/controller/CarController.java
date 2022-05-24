package pl.mateusz.Cars.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.enums.SegmentType;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/Cars")
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

    @Secured("ROLE_ADMIN")
    @GetMapping("/addCar")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("CarSegment", SegmentType.values());
        model.addAttribute("brand", brandService.findAll());
        return "addCar";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/addCar")
    public String addCarForm(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "addCar";
        }
        carService.save(car);
        return "redirect:/listCar" ;
    }

    @Secured("ROLE_ADMIN")
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

    @Secured("ROLE_ADMIN")
    @PostMapping("/updateCar/{id}")
    public String updateCarForm(@PathVariable Long id,@Valid Car car){
        carService.update(car);
        return "redirect:/Cars/listCar";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("safetyDeleteCar/{id}")
    public String safetyDeleteCar(@PathVariable String id, Model model){
        model.addAttribute("id", id);
        return "deleteCar";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("deleteCar/{id}")
    public String deleteCar(@PathVariable String id){
        carService.delete(Long.parseLong(id));
        return "redirect:/Cars//listCar";
    }
}

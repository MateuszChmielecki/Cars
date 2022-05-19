package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.Cars.entity.Brand;
import pl.mateusz.Cars.entity.Group;
import pl.mateusz.Cars.enums.SegmentType;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;



@Controller
public class HomeController {

    private final CarService carService;
    private final BrandService brandService;
    private final GroupService groupService;

    public HomeController(CarService carService, BrandService brandService, GroupService groupService) {
        this.carService = carService;
        this.brandService = brandService;
        this.groupService = groupService;
    }

}




package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateusz.Cars.entity.Brand;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;


@Controller
public class BrandController {

    private final CarService carService;
    private final BrandService brandService;
    private final GroupService groupService;

    public BrandController(CarService carService, BrandService brandService, GroupService groupService) {
        this.carService = carService;
        this.brandService = brandService;
        this.groupService = groupService;
    }

    @GetMapping("/listBrand")
    public String listBrands(Model model){
        model.addAttribute("brands", brandService.findAll());
        return "listBrand";
    }

    @GetMapping("/addBrand")
    public String addBrand(Model model) {
        model.addAttribute("brand", new Brand());
        model.addAttribute("group", groupService.findAll());
        return "addBrand";
    }

    @PostMapping("/addBrand")
    public String addBrandForm(@Valid Brand brand, BindingResult result) {
        if (result.hasErrors()) {
            return "addBrand";
        }
        brandService.save(brand);
        return "redirect:/listBrand" ;
    }

}

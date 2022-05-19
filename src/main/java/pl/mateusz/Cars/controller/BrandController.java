package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/updateBrand/{id}")
    public String updateBrand(@PathVariable String id, Model model){

        if(brandService.findById(Long.parseLong(id)).isPresent()) {

            model.addAttribute("brand", brandService.findById(Long.parseLong(id)).get());
            model.addAttribute("group", groupService.findAll());
            return "updateBrand";
        }
        return "listBrand";
    }


    @PostMapping("/updateBrand/{id}")
    public String updateBrandForm(@PathVariable Long id,@Valid Brand brand){
        brandService.update(brand);
        return "redirect:/listBrand";
    }

    @GetMapping("safetyDeleteBrand/{id}")
    public String safetyDeleteBrand(@PathVariable String id, Model model){
        model.addAttribute("id", id);
        return "deleteBrand";
    }

    @GetMapping("deleteBrand/{id}")
    public String deleteBrand(@PathVariable String id){
        brandService.delete(Long.parseLong(id));
        return "redirect:/listBrand";
    }

}

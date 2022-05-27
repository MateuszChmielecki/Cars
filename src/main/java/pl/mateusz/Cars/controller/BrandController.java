package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.Cars.services.BrandService;


@Controller
@RequestMapping(path ="/Cars")
public class BrandController {


    private final BrandService brandService;


    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/listBrand")
    public String listBrands(Model model){
        model.addAttribute("brands", brandService.findAll());
        return "brand/listBrand";
    }
}

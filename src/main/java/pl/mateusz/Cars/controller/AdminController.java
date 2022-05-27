package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.Cars.entity.Brand;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.entity.Group;
import pl.mateusz.Cars.enums.SegmentType;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;

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
        return "car/addCar";
    }

    @PostMapping("/addCar")
    public String addCarForm(@Valid Car car, BindingResult result) {

           if (result.hasErrors()) {
               return "car/addCar";
           }

        carService.save(car);
        return "redirect:/Cars/listCar" ;
    }

    @GetMapping("/updateCar/{id}")
    public String updateCar(@PathVariable String id, Model model){
            if(carService.findById(Long.parseLong(id)).isPresent()) {

                model.addAttribute("car", carService.findById(Long.parseLong(id)).get());
                model.addAttribute("CarSegment", SegmentType.values());
                model.addAttribute("brand", brandService.findAll());
                return "car/updateCar";
            }
        return "car/updateCar";
    }

    @PostMapping("/updateCar/{id}")
    public String updateCarForm(@PathVariable Long id,@Valid Car car){
        carService.update(car);
        return "redirect:/Cars/listCar";
    }

    @GetMapping("safetyDeleteCar/{id}")
    public String safetyDeleteCar(@PathVariable String id, Model model){
        model.addAttribute("id", id);
        return "car/deleteCar";
    }

    @GetMapping("deleteCar/{id}")
    public String deleteCar(@PathVariable String id){
        carService.delete(Long.parseLong(id));
        return "redirect:/Cars/listCar";
    }
    @GetMapping("/addBrand")
    public String addBrand(Model model) {
        model.addAttribute("brand", new Brand());
        model.addAttribute("group", groupService.findAll());
        return "brand/addBrand";
    }

    @PostMapping("/addBrand")
    public String addBrandForm(@Valid Brand brand, BindingResult result) {
        if (result.hasErrors()) {
            return "brand/addBrand";
        }
        brandService.save(brand);
        return "redirect:/Cars/listBrand" ;
    }

    @GetMapping("/updateBrand/{id}")
    public String updateBrand(@PathVariable String id, Model model){

        if(brandService.findById(Long.parseLong(id)).isPresent()) {

            model.addAttribute("brand", brandService.findById(Long.parseLong(id)).get());
            model.addAttribute("group", groupService.findAll());
            return "brand/updateBrand";
        }
        return "brand/listBrand";
    }

    @PostMapping("/updateBrand/{id}")
    public String updateBrandForm(@PathVariable Long id,@Valid Brand brand){
        brandService.update(brand);
        return "redirect:/Cars/listBrand";
    }

    @GetMapping("safetyDeleteBrand/{id}")
    public String safetyDeleteBrand(@PathVariable String id, Model model){
        model.addAttribute("id", id);
        return "brand/deleteBrand";
    }

    @GetMapping("deleteBrand/{id}")
    public String deleteBrand(@PathVariable String id){
        brandService.delete(Long.parseLong(id));
        return "redirect:/Cars/listBrand";
    }

    @GetMapping("/addGroup")
    public String addGroup(Model model) {
        model.addAttribute("group", new Group());
        return "group/addGroup";
    }

    @PostMapping("/addGroup")
    public String addGroupForm(@Valid Group group, BindingResult result) {
        if (result.hasErrors()) {
            return "group/addGroup";
        }
        groupService.save(group);
        return "redirect:/Cars/listGroup" ;
    }

    @GetMapping("/updateGroup/{id}")
    public String updateGroup(@PathVariable String id, Model model){

        if(groupService.findById(Long.parseLong(id)).isPresent()) {

            model.addAttribute("group", groupService.findById(Long.parseLong(id)).get());
            return "group/updateGroup";
        }
        return "group/listGroup";
    }

    @PostMapping("/updateGroup/{id}")
    public String updateGroupForm(@PathVariable Long id,@Valid Group group){
        groupService.update(group);
        return "redirect:/Cars/listGroup";
    }

    @GetMapping("safetyDeleteGroup/{id}")
    public String safetyDeleteGroup(@PathVariable String id, Model model){
        model.addAttribute("id", id);
        return "group/deleteGroup";
    }

    @GetMapping("deleteGroup/{id}")
    public String deleteGroup(@PathVariable String id){
        groupService.delete(Long.parseLong(id));
        return "redirect:/Cars/listGroup";
    }

}

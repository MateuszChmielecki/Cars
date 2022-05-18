package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateusz.Cars.entity.Group;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;

@Controller
public class GroupController {

    private final CarService carService;
    private final BrandService brandService;
    private final GroupService groupService;

    public GroupController(CarService carService, BrandService brandService, GroupService groupService) {
        this.carService = carService;
        this.brandService = brandService;
        this.groupService = groupService;
    }

    @GetMapping("/listGroup")
    public String listGroups(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "listGroup";
    }

    @GetMapping("/addGroup")
    public String addGroup(Model model) {
        model.addAttribute("group", new Group());
        return "addGroup";
    }

    @PostMapping("/addGroup")
    public String addGroupForm(@Valid Group group, BindingResult result) {
        if (result.hasErrors()) {
            return "addGroup";
        }
        groupService.save(group);
        return "redirect:/listGroup" ;
    }


}

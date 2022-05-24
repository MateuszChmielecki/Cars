package pl.mateusz.Cars.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.Cars.entity.Group;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/Cars")
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

    @Secured("ROLE_ADMIN")
    @GetMapping("/addGroup")
    public String addGroup(Model model) {
        model.addAttribute("group", new Group());
        return "addGroup";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/addGroup")
    public String addGroupForm(@Valid Group group, BindingResult result) {
        if (result.hasErrors()) {
            return "addGroup";
        }
        groupService.save(group);
        return "redirect:/Cars/listGroup" ;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/updateGroup/{id}")
    public String updateGroup(@PathVariable String id, Model model){

        if(groupService.findById(Long.parseLong(id)).isPresent()) {

            model.addAttribute("group", groupService.findById(Long.parseLong(id)).get());
            return "updateGroup";
        }
        return "listGroup";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/updateGroup/{id}")
    public String updateGroupForm(@PathVariable Long id,@Valid Group group){
        groupService.update(group);
        return "redirect:/Cars/listGroup";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("safetyDeleteGroup/{id}")
    public String safetyDeleteGroup(@PathVariable String id, Model model){
        model.addAttribute("id", id);
        return "deleteGroup";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("deleteGroup/{id}")
    public String deleteGroup(@PathVariable String id){
        groupService.delete(Long.parseLong(id));
        return "redirect:/Cars/listGroup";
    }

}

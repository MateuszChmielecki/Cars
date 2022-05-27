package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.Cars.services.GroupService;


@Controller
@RequestMapping(path="/Cars")
public class GroupController {


    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/listGroup")
    public String listGroups(Model model){
        model.addAttribute("groups", groupService.findAll());
        return "group/listGroup";
    }

}

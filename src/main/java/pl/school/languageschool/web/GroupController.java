package pl.school.languageschool.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupController {
    private GroupController groupController;

    public GroupController(GroupController groupController) {
        this.groupController = groupController;
    }

    public GroupController(){}
}

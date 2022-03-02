package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.RoleService;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("/listRole")
    public String home(Model model){
        model.addAttribute("listRole", roleService.getAllRole());
        return "select";
    }
}

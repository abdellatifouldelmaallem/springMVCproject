package controllers;

import entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.AdminService;

import javax.validation.Valid;
import java.util.Map;


@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

   @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String adminLogin(@Valid Admin admin, BindingResult result, Map model){

        if (result.hasErrors()) {
            return "login";
        }

        String email = "abdellatif@gmail.com";
        String password = "12345";

        admin = (Admin) model.get(admin);
        if (!admin.getEmail().equals(email) || !admin.getPassWord().equals(password)){
           return "login";
        }

        Boolean adminExists = adminService.isLoged(admin.getEmail(),admin.getPassWord());
        if (adminExists){
            return "redirect:/trainers";
        }


        return "login";
    }

}

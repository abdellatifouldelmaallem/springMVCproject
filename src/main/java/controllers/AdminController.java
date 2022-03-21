package controllers;


import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import service.AdminService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

   @GetMapping("/")
    public String showFromLogin(User user) {
        return "login";
    }

    @PostMapping("/loginFail")

    public String adminLogin(@Valid User user, BindingResult bindingResult, Model model, HttpSession session){

        if (bindingResult.hasErrors()) {
            return "login";
        }

       String email= user.getEmail();
       String password = user.getPassWord();

        if (email.length()>0 && password.length()>0){
            boolean adminExsits = adminService.isLoged(email,password);
            if (adminExsits){
                System.out.println("login done with successfully");
                session.setAttribute("email",email);
                session.setAttribute("password",password);
                return "redirect:/admin/trainers";
            }else {
                System.out.println("login fail");
                model.addAttribute("message","your email or password is not corresct");
                return "login";
            }
        }

         return "login";
    }

}

package controllers;

import entities.Role;
import entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.RoleService;
import service.TrainerService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class TrainerController {
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/trainers")
    public String Trainers(Model model){
     model.addAttribute("listTrainers", trainerService.getAllTrainer());
     return "trainers";
    }

    @GetMapping("/showNewTrainerForm")
    public String showNewTrainerForm(Model model) {

        Trainer trainer = new Trainer();
        model.addAttribute("trainer", trainer);
        model.addAttribute("listRole", roleService.getAllRole());
        return "newTrainer";
    }

    @PostMapping("/saveTrainer")
    public String saveTrainer(@ModelAttribute("trainer") Trainer trainer) {
        Role role = roleService.getRoleById(3L);
        trainer.setRole(role);
        trainerService.RsaveTrainer(trainer);
        return "redirect:/trainers";
    }

    @RequestMapping("/deleteTrainer/{id}")
    public String deleteTrainer(@PathVariable(name = "id") Long id){
        trainerService.RdeleteTrainer(id);
        return "redirect:/trainers";
    }

    @RequestMapping("/showEditTrainerForm/{id}")
    public String editTrainer(@PathVariable(name = "id") Long id, Model model){
        Trainer trainer = trainerService.RgetById(id);
         model.addAttribute("trainer",trainer);
        return "edit_trainer";
    }

    @PostMapping("/updateTrainer")
    public String updateTrainer(@Valid Trainer trainer, HttpServletRequest req) {
        Long idUser = Long.parseLong(req.getParameter("idUser"));
        trainer.setId(idUser);
        Role role = roleService.getRoleById(3L);
        trainer.setRole(role);
        trainerService.Rupdate(trainer);
        return "redirect:/trainers";
    }



}

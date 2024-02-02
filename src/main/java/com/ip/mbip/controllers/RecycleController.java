package com.ip.mbip.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ip.mbip.model.Recycle;
import com.ip.mbip.model.User;
import com.ip.mbip.model.WaterBill;
import com.ip.mbip.repository.RecycleRepo;
import com.ip.mbip.service.RecycleService;
import com.ip.mbip.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RequestMapping(value = "/api/recycle")
public class RecycleController {

    @Autowired
    private RecycleService recycleService;

    @Autowired
    private UserService userService; // Create UserService

    @GetMapping("/viewRecycleUser")
    public String recycle(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("recycle", recycleService.findByUser(user));
        return "viewRecycleUser";
    }


    @GetMapping("/recycleBillForm")
    public String showRecycleBillForm(Model model) {
        model.addAttribute("recycle", new Recycle());
        return "recycleBillForm";
    }

    @PostMapping("/save")
    public String addRecycle(Recycle recycle, Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        recycle.setUser(user);
        recycleService.addRecycle(recycle);
        return "redirect:/viewRecycleUser";
    }

    @GetMapping("/deleteRec/{id}")
    public String deleteRec(@PathVariable("id") Long id) {

        recycleService.deleteById(id);
        return "redirect:/viewRecycleUser";
    }

    @GetMapping("/editRec/{id}")
    public String editCase(@PathVariable("id") Long id, Model model) {

        model.addAttribute("recycle", recycleService.findById(id));
        return "editRecycleForm";
    }

    @PostMapping("/update")
    public String editTestCaseForm(Recycle recycle, Model model) {

        recycleService.updateRecycle(recycle);
        return "redirect:/viewRecycleUser";
    }

}

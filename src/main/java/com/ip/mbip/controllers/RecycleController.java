package com.ip.mbip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ip.mbip.model.Recycle;
import com.ip.mbip.repository.RecycleRepo;
import com.ip.mbip.service.RecycleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
// @RequestMapping(value = "/api/recycle")
public class RecycleController {

    @Autowired
    private RecycleService recycleService;


    @GetMapping("/viewRecycleUser")
    public String recycle(Model model) {
        // List<TestCase> cases = viewCaseService.findAllList();
        model.addAttribute("recycle", recycleService.findAll());
        return "viewRecycleUser";
    }


    @GetMapping("/recycleBillForm")
    public String showRecycleBillForm(Model model) {
        model.addAttribute("recycle",new Recycle());
        return "recycleBillForm";
    }

    @PostMapping("/save")
	public String addRecycle(Recycle recycle,Model model) {
		recycleService.addRecycle(recycle);// save product into database, using DbService
		return "redirect:/viewRecycle";
	}

    @GetMapping("/deleteRec/{id}")
	public String deleteRec(@PathVariable("id") Long id) {
		
       recycleService.deleteById(id);
		return "redirect:/viewRecycle";
	}

    @GetMapping("/editRec/{id}")
	public String editCase(@PathVariable("id") Long id,Model model) {
		
        model.addAttribute("recycle", recycleService.findById(id));
		return "editRecycleForm";
	}

    @PostMapping("/update")
	public String editTestCaseForm(Recycle recycle,Model model) {
		
        recycleService.updateRecycle(recycle);
		return "redirect:/viewRecycle";
	}

    
}

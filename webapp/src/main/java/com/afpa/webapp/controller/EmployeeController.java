package com.afpa.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.afpa.webapp.model.Employee;
import com.afpa.webapp.service.EmployeeService;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Employee> listEmployee = EmployeeService.getEmployees();
        model.addAttribute("employees", listEmployee);
    
    return "home";
    }

    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
        EmployeeService.deleteEmployee(id);
    return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        EmployeeService.saveEmployee(employee);
    return new ModelAndView("redirect:/");
    }
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Position;
import com.example.demo.model.Employee;
import com.example.demo.service.PositionSv;
import com.example.demo.service.EmployeeSv;
import com.example.demo.service.SecurityService;

@Controller
public class Employeecontroller {
	@Autowired
	private EmployeeSv service;
	@Autowired
	private PositionSv service1;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private EmployeeValidator userValidator;

	@RequestMapping("/viewEmployee")
	public String viewHomePage(Model model) {
		List<Employee> listEmployee = service.listAll();
		model.addAttribute("listEmployee", listEmployee);

		List<Position> listPosition = service1.listAll();
		model.addAttribute("listPosition", listPosition);
		return "viewEmployee";
	}

	@RequestMapping("/createEmployee")
	public String showNewEmployeePage(Model model) {
		Employee Employee = new Employee();
		model.addAttribute("Employee", Employee);
		List<Position> listPosition = service1.listAll();
		model.addAttribute("listPosition", listPosition);
		return "createEmployee";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("Employee") Employee Employee) {
		service.save(Employee);
		return "redirect:/viewEmployee";
	}

	@RequestMapping("/editEmployee/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id, Model model) {
		ModelAndView mav = new ModelAndView("editEmployee");
		Employee Employee = service.get(id);
		mav.addObject("employee", Employee);
		List<Position> listPosition = service1.listAll();
		model.addAttribute("listposition", listPosition);
		return mav;
	}

	@RequestMapping("/deleteEmployee/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/viewEmployee";
	}

	// USER	PAGE
	@RequestMapping("/info")
	public String viewuser(Authentication auth, Model model) {
		model.addAttribute("listEmployee", service.getinfouser(auth.getName()));
		return "viewuserEmployee";
	}

	@RequestMapping("/edituserEmployee/{id}")
	public ModelAndView showEdituserProductPage(@PathVariable(name = "id") int id, Model model) {
		ModelAndView mav = new ModelAndView("edituserEmployee");
		Employee Employee = service.get(id);
		mav.addObject("employee", Employee);
		List<Position> listPosition = service1.listAll();
		model.addAttribute("listposition", listPosition);
		return mav;
	}
	
	@RequestMapping(value = "/saveuserEmployee", method = RequestMethod.POST)
	public String saveEmployeeuser(@ModelAttribute("Employee") Employee Employee) {
		service.save(Employee);
		return "redirect:/info";
	}

	// LOGN IN USER
	@GetMapping("/registration")
	public String registration(Model model) {
		if (securityService.isAuthenticated()) {
			return "redirect:/";
		}
		model.addAttribute("userForm", new Employee());
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") Employee userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		service.save(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
		return "redirect:/info";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (securityService.isAuthenticated()) {
			return "redirect:/info";
		}
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}

	// Change UI LogIn Admin User (Employee - info)
	@GetMapping({ "/", "/user" })
	public String welcome(Model model) {
		return "redirect:/info";
	}

}
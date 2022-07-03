package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Registration;
import com.example.demo.service.EmployeeSv;
import com.example.demo.service.RegistrationSv;

@Controller
public class Registrationcontroller {
	@Autowired
	private RegistrationSv service;
	
	@Autowired
	private EmployeeSv service1;

	@RequestMapping("/viewRegistration")
	public String viewHomePage(Model model) {
		List<Registration> listRegistration = service.listAll();
		model.addAttribute("listRegistration", listRegistration);
		return "viewRegistration";
	}

	@RequestMapping("/createuserRegistration")
	public String showNewRegistrationPage(Authentication auth,Model model) {
		Registration Registration = new Registration();
		model.addAttribute("Registration", Registration);
		model.addAttribute("listEmployee", service1.getinfouser(auth.getName()));
		return "createuserRegistration";
	}

	@RequestMapping(value = "/saveRegistration", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("Registration") Registration Registration) {
		service.save(Registration);
		return "redirect:/viewRegistration";
	}

	@RequestMapping("/editRegistration/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editRegistration");
		Registration Registration = service.get(id);
		mav.addObject("Registration", Registration);
		return mav;
	}

	@RequestMapping("/deleteRegistration/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/viewRegistration";
	}
	
	//USER
	@RequestMapping("/viewuserRegistration")
	public String viewuserregisttration(Model model,Authentication auth) {
		List<Registration> listRegistration = service.listuserregistration(auth.getName());
		model.addAttribute("listRegistration", listRegistration);
		return "viewuserRegistration";
	}
	
	@RequestMapping("/edituserRegistration/{id}")
	public ModelAndView showEdituserregistration(@PathVariable(name = "id") int id,Authentication auth,Model model) {
		model.addAttribute("listEmployee", service1.getinfouser(auth.getName()));
		ModelAndView mav = new ModelAndView("edituserRegistration");
		Registration Registration = service.get(id);
		mav.addObject("Registration", Registration);
		return mav;
	}
	
	@RequestMapping("/deleteuserRegistration/{id}")
	public String deleteProductuser(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/viewuserRegistration";
	}
	
	@RequestMapping(value = "/saveuserRegistration", method = RequestMethod.POST)
	public String saveregistrationuser(@ModelAttribute("Registration") Registration Registration) {
		service.save(Registration);
		return "redirect:/viewuserRegistration";
	}
}



















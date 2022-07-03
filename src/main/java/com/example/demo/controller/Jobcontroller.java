package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Job;
import com.example.demo.model.Employee;
import com.example.demo.service.JobSv;
import com.example.demo.service.EmployeeSv;

@Controller
public class Jobcontroller {
	@Autowired
	private JobSv service;
	@Autowired
	private EmployeeSv service1;

	@RequestMapping("/viewJob")
	public String viewHomePage(Model model) {
		List<Job> listJob = service.listAll();
		model.addAttribute("listJob", listJob);
		return "viewJob";
	}

	@RequestMapping("/createJob")
	public String showNewJobPage(Model model) {
		Job Job = new Job();
		model.addAttribute("Job", Job);
		List<Employee> listEmployee = service1.listAll();
		model.addAttribute("listEmployee", listEmployee);
		return "createJob";
	}

	@RequestMapping(value = "/saveJob", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("Job") Job Job) {
		service.save(Job);
		return "redirect:/viewJob";
	}

	@RequestMapping("/editJob/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editJob");
		Job Job = service.get(id);
		mav.addObject("Job", Job);
		return mav;
	}

	@RequestMapping("/deleteJob/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/viewJob";
	}

	@RequestMapping("/Jobuser")
	public String viewJobuser(Model model) {
		List<Job> listJob = service.listAll();
		model.addAttribute("listJob", listJob);

		return "Jobuser";
	}

}
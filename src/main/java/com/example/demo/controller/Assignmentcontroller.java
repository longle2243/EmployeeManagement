package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Assignment;
import com.example.demo.model.Job;
import com.example.demo.model.Registration;
import com.example.demo.service.AssignmentSv;
import com.example.demo.service.JobSv;
import com.example.demo.service.RegistrationSv;

@Controller
public class Assignmentcontroller {
	@Autowired
	private AssignmentSv assignmentSv;
	@Autowired
	private JobSv servicecv;
	@Autowired
	private RegistrationSv service1;
	
	@GetMapping("/viewAssignment")
	public String viewindex(Model model) {
		model.addAttribute("listAssignment",assignmentSv.listAll());
		return "viewAssignment";
	}

	@GetMapping("/filterallsalary")
	public String view() {
		return "filterallsalary";
	}
	
	@GetMapping("/filtersalaryuser")
	public String viewsalaryuser() {
		return "filtersalaryuser";
	}
	
	@PostMapping("/salaryall")
	public String viewtest(@RequestParam(value="start") String start ,@RequestParam(value="end") String end, Model model) {
		model.addAttribute("listchitiet",assignmentSv.getAllSalary(start,end));
		return "salaryall";
	}
	
	@PostMapping("/salaryuser")
	public String viewtest(@RequestParam(value="start") String start ,@RequestParam(value="end") String end,@RequestParam(value="idemp") Integer idemp, Model model) {
		model.addAttribute("listchitiet",assignmentSv.getSalary(start,end,idemp));
		return "salaryuser";
	}
	
	@RequestMapping(value = "/saveAssignment", method = RequestMethod.POST)
	public String saveAssignment(@ModelAttribute("Assignment") Assignment Assignment) {
		assignmentSv.save(Assignment);
	    return "redirect:/viewAssignment";
	}
	
	@RequestMapping("/createAssignment")
	public String showNewChamCongPage(Model model) {
	    Assignment Assignment = new Assignment();
	    model.addAttribute("Assignment", Assignment);	

	    List<Job> listJob= servicecv.listAll();
	    model.addAttribute("listJob", listJob);
	    
		List<Registration> listRegistration = service1.listAll();
		model.addAttribute("listregistrationAll", listRegistration);
	    List<Object[]> listJobSang= service1.Jobsang();
	    model.addAttribute("listregistrationM", listJobSang);
	    List<Object[]> listJobChieu= service1.Jobchieu();
	    model.addAttribute("listregistrationA", listJobChieu);
	    List<Object[]> listJobToi= service1.Jobtoi();
	    model.addAttribute("listregistrationE", listJobToi);
	    return "createAssignment";
	}
	
	//USER
	@GetMapping("/viewuserAssignment")
	public String viewuserassignment(Model model) {
		model.addAttribute("listAssignment",assignmentSv.listAll());
		return "viewuserAssignment";
	}
}

















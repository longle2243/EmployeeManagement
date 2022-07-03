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

import com.example.demo.model.Position;
import com.example.demo.service.PositionSv;

@Controller
public class Positioncontroller {
	@Autowired
	private PositionSv service;

	@RequestMapping("/viewPosition")
	public String viewHomePage(Model model) {
		List<Position> listPosition = service.listAll();
		model.addAttribute("listPosition", listPosition);
		return "viewPosition";
	}

	@RequestMapping("/createPosition")
	public String showNewPositionPage(Model model) {
		Position Position = new Position();
		model.addAttribute("Position", Position);
		return "createPosition";
	}

	@RequestMapping(value = "/savePosition", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("Position") Position Position) {
		service.save(Position);
		return "redirect:/viewPosition";
	}

	@RequestMapping("/editPosition/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editPosition");
		Position Position = service.get(id);
		mav.addObject("Position", Position);
		return mav;
	}

	@RequestMapping("/deletePosition/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/viewPosition";
	}
}

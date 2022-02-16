package com.example.democontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.demoentity.Employee;
import com.example.demoservice.EmpService;

@Controller

public class EmpController {

	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home() {
		return "info";
	}

	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("employee", new Employee());
		return "new";
	}

	@GetMapping("/index")
	public String viewHomePAge(Model model) {
		List<Employee> listEmployee = service.listAll();
		model.addAttribute("listEmployee", listEmployee);
		System.out.print("Get/");
		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		service.save(emp);
		return "redirect:/index";
	}

	@GetMapping("/listEmployee/edit/{id}")
	public ModelAndView showEditEmployeePage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("new");
		Employee emp = service.get(id);
		mav.addObject("employee", emp);
		//	mav.setViewName("index");
		return mav;
	}

	@GetMapping("/listEmployee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") long id) {
		service.delete(id);
		return "redirect:/index";
	}
}

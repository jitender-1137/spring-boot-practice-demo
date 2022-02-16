package com.example.democontroller;

import com.example.demoentity.Department;
import com.example.demoservice.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepController {
	@Autowired
	private DepService depService;

	@GetMapping("/newDep")
	public String departAdd(Model model) {
		model.addAttribute("department", new Department());
		return "newDep";
	}

	@GetMapping("/dep")
	public String getDepartment(Model model) {
		List<Department> listDepartment = depService.listAll();
		model.addAttribute("listDepartment", listDepartment);
		return "dep";
	}

	@RequestMapping(value = "/saveDep", method = RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("department") Department dep) {
		depService.save(dep);
		return "redirect:/dep";
	}
}

package com.example.demoservice;

import com.example.demoentity.Department;
import com.example.demorepository.DepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DepService {

	@Autowired
	private DepRepo depRepo;

	public List<Department> listAll() {
		return depRepo.findAll();
	}

	public void save(Department dep) {
		depRepo.save(dep);
	}
}


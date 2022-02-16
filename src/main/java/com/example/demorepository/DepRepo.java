package com.example.demorepository;

import com.example.demoentity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepRepo extends JpaRepository<Department, Long> {

}
